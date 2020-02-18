import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Partitionner<T> {
    Logger logger = Logger.getLogger(Partitionner.class.getName());

    /**
     * Méthode permettant de partitionner une liste d'objets
     * @param list liste d'objets à partitionner
     * @param partitionSizeMax taille maximale chacune des partitions
     * @return liste contenant des sous listes d'objets
     * @throws PartitionnerException exception pouvant se produire
     */
    public List<List<T>> partition(List<T> list, int partitionSizeMax) throws PartitionnerException {
        if (!CollectionUtils.isEmpty(list) && partitionSizeMax > 0 && partitionSizeMax <= list.size()) {
            int nbreParts = (int) Math.ceil(list.size() / (double) partitionSizeMax);
            List<T>[] tabPartitions = new ArrayList[nbreParts];
            int currentIndex = 0;
            for (int i = 0; i < nbreParts; i++) {
                int increment = getIncrementOfCurrentIndex(currentIndex, partitionSizeMax, list.size());
                tabPartitions[i] = new ArrayList<T>(list.subList(currentIndex, currentIndex + increment));;
                currentIndex += increment;
            }
            return  Arrays.asList(tabPartitions);
        } else if (CollectionUtils.isEmpty(list)) {
            logger.info(PartitionnerErrorMessage.NULL_OR_EMPTY_LIST);
            throw new PartitionnerException(PartitionnerErrorMessage.NULL_OR_EMPTY_LIST);
        } else {
            logger.info(PartitionnerErrorMessage.INCORRECT_PARTITION_SIZE);
            throw new PartitionnerException(PartitionnerErrorMessage.INCORRECT_PARTITION_SIZE);
        }
    }

    /***
     * Méthode permettant de calculer l'incrément de l'index de parcours de la liste
     * @param currentIndex index courant de la liste
     * @param partitionSizeMax taille maximale de la partition
     * @param sizeList taille de la liste d'objets
     * @return valeur exacte de l'incrément
     */
    public int getIncrementOfCurrentIndex(int currentIndex, int partitionSizeMax, int sizeList) {
        if (currentIndex + partitionSizeMax > sizeList) {
            return sizeList - currentIndex;
        } else {
            return partitionSizeMax;
        }
    }
}
