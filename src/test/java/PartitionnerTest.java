import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionnerTest {

    private Integer[] intTab = new Integer[]{1, 2, 3, 4, 5};
    private String[] stringTab = new String[]{"tennis", "foot", "basket"};

    /**
     * Test du partitionneur sur une liste de nombre entiers cas1
     * On partitionne notre liste d'entiers en sous listes contenant chacune 1 nombre entier au maximum
     */
    @Test
    public void partitionListOfOneInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        List<List<Integer>> partitionsOfOne = partitionner.partition(Arrays.asList(intTab), 1);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfOne);
        // On verifie qu'on a 5 sous listes
        Assert.assertEquals(5, partitionsOfOne.size());
        // on vérifie que chaque sous liste a un seul élément
        partitionsOfOne.stream().forEach(p -> Assert.assertEquals(1, p.size()));
        // On vérifie que chaque sous liste contient l'entier attendu
        Assert.assertTrue(partitionsOfOne.get(0).contains(1));
        Assert.assertTrue(partitionsOfOne.get(1).contains(2));
        Assert.assertTrue(partitionsOfOne.get(2).contains(3));
        Assert.assertTrue(partitionsOfOne.get(3).contains(4));
        Assert.assertTrue(partitionsOfOne.get(4).contains(5));
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas2
     * On partitionne notre liste d'entiers en sous listes contenant chacune 2 nombres entier au maximum
     */
    @Test
    public void partitionListOfTwoInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        List<List<Integer>> partitionsOfTwo = partitionner.partition(Arrays.asList(intTab), 2);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfTwo);
        // On verifie qu'on a 3 sous listes
        Assert.assertEquals(3, partitionsOfTwo.size());
        // On vérfie les tailles de chacune des sous listes
        Assert.assertEquals(2, partitionsOfTwo.get(0).size());
        Assert.assertEquals(2, partitionsOfTwo.get(1).size());
        Assert.assertEquals(1, partitionsOfTwo.get(2).size());
        // On vérifie que chaque sous liste a le(s) entier(s) attendu(s)
        Assert.assertTrue(partitionsOfTwo.get(0).contains(1));
        Assert.assertTrue(partitionsOfTwo.get(0).contains(2));
        Assert.assertTrue(partitionsOfTwo.get(1).contains(3));
        Assert.assertTrue(partitionsOfTwo.get(1).contains(4));
        Assert.assertTrue(partitionsOfTwo.get(2).contains(5));
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas3
     * On partitionne notre liste d'entiers en sous listes contenant chacune 3 nombres entier au maximum
     */
    @Test
    public void partitionListOfThreeInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        List<List<Integer>> partitionsOfThree = partitionner.partition(Arrays.asList(intTab), 3);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfThree);
        // On verifie qu'on a 2 sous listes
        Assert.assertEquals(2, partitionsOfThree.size());
        // On vérfie les tailles de chacune des sous listes
        Assert.assertEquals(3, partitionsOfThree.get(0).size());
        Assert.assertEquals(2, partitionsOfThree.get(1).size());
        // On vérifie que chaque sous liste a le(s) entier(s) attendu(s)
        Assert.assertTrue(partitionsOfThree.get(0).contains(1));
        Assert.assertTrue(partitionsOfThree.get(0).contains(2));
        Assert.assertTrue(partitionsOfThree.get(0).contains(3));
        Assert.assertTrue(partitionsOfThree.get(1).contains(4));
        Assert.assertTrue(partitionsOfThree.get(1).contains(5));
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas4
     * On partitionne notre liste d'entiers en sous listes contenant chacune 4 nombres entier au maximum
     */
    @Test
    public void partitionListOfFourInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        List<List<Integer>> partitionsOfFour = partitionner.partition(Arrays.asList(intTab), 4);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfFour);
        // On verifie qu'on a 2 sous listes
        Assert.assertEquals(2, partitionsOfFour.size());
        // On vérfie les tailles de chacune des sous listes
        Assert.assertEquals(4, partitionsOfFour.get(0).size());
        Assert.assertEquals(1, partitionsOfFour.get(1).size());
        // On vérifie que chaque sous liste contient les entiers attendus
        Assert.assertTrue(partitionsOfFour.get(0).contains(1));
        Assert.assertTrue(partitionsOfFour.get(0).contains(2));
        Assert.assertTrue(partitionsOfFour.get(0).contains(3));
        Assert.assertTrue(partitionsOfFour.get(0).contains(4));
        Assert.assertTrue(partitionsOfFour.get(1).contains(5));
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas5
     * On partitionne notre liste d'entiers en sous listes contenant chacune 5 nombres entier au maximum
     */
    @Test
    public void partitionListOfFiveInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        List<List<Integer>> partitionsOfFive = partitionner.partition(Arrays.asList(intTab), 5);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfFive);
        // On verifie qu'on a 2 sous listes
        Assert.assertEquals(1, partitionsOfFive.size());
        // On vérfie les tailles de chacune des sous listes
        Assert.assertEquals(5, partitionsOfFive.get(0).size());
        // On vérifie que chaque sous liste contient les entiers attendus
        Assert.assertTrue(partitionsOfFive.get(0).contains(1));
        Assert.assertTrue(partitionsOfFive.get(0).contains(2));
        Assert.assertTrue(partitionsOfFive.get(0).contains(3));
        Assert.assertTrue(partitionsOfFive.get(0).contains(4));
        Assert.assertTrue(partitionsOfFive.get(0).contains(5));
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas6
     * On partitionne notre liste d'entiers en sous listes contenant chacune 6 nombres entier au maximum
     * On se rassure qu'on a bien une exception de type PartitionnerException avec le message d'erreur apparoprié
     */

    @Test(expected = PartitionnerException.class)
    public void partitionListOfSixInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        partitionner.partition(Arrays.asList(intTab), 6);
    }

    /**
     * Test du partitionneur sur une liste de nombre entiers cas7
     * On partitionne notre liste d'entiers avec un nombre négatif
     * On se rassure qu'on a bien une exception de type PartitionnerException avec le message d'erreur apparoprié
     */

    @Test
    public void partitionListOfNegateInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        try {
            partitionner.partition(Arrays.asList(intTab), -1);
        }catch (Exception e){
            Assert.assertTrue(e instanceof PartitionnerException);
            Assert.assertEquals(PartitionnerErrorMessage.INCORRECT_PARTITION_SIZE, e.getMessage());
        }
    }

    /**
     * Test du partitionneur sur une liste vide de nombre entiers cas8
     * On partitionne notre liste  vide d'entiers
     * On se rassure qu'on a bien une exception de type PartitionnerException avec le message d'erreur apparoprié
     */

    @Test
    public void partitionEmptyListOfInteger() throws PartitionnerException {
        Partitionner<Integer> partitionner = new Partitionner<>();
        try {
            partitionner.partition(new ArrayList<>(), 1);
        }catch (Exception e){
            Assert.assertTrue(e instanceof PartitionnerException);
            Assert.assertEquals(PartitionnerErrorMessage.NULL_OR_EMPTY_LIST, e.getMessage());
        }
    }

    /**
     * Test du partitionneur sur une liste de chaines de caractères cas1
     * On partitionne notre liste de chaines de caractère en sous listes contenant chacune 2 chaines de caractères au maximum
     */
    @Test
    public void partitionListOfTwoString() throws PartitionnerException {
        Partitionner<String> partitionner = new Partitionner<>();
        List<List<String>> partitionsOfTwo = partitionner.partition(Arrays.asList(stringTab), 2);
        // On vérifie que la liste de sous listes est non nulle
        Assert.assertNotNull(partitionsOfTwo);
        // On verifie qu'on a 2 sous listes
        Assert.assertEquals(2, partitionsOfTwo.size());
        // On vérfie les tailles de chacune des sous listes
        Assert.assertEquals(2, partitionsOfTwo.get(0).size());
        Assert.assertEquals(1, partitionsOfTwo.get(1).size());
        // On vérifie que chaque sous liste contient les entiers attendus
        Assert.assertTrue(partitionsOfTwo.get(0).contains("tennis"));
        Assert.assertTrue(partitionsOfTwo.get(0).contains("foot"));
        Assert.assertTrue(partitionsOfTwo.get(1).contains("basket"));
    }

    /**
     * Test du partitionneur sur une liste de chaines de caractères cas 2
     * On partitionne notre liste de chaines de caractère en sous listes contenant chacune 4 chaines de caractères au maximum
     * On se rassure qu'on a bien une exception de type PartitionnerException
     */
    @Test
    public void partitionListOfFourString() {
        Partitionner<String> partitionner = new Partitionner<>();
        try {
            partitionner.partition(Arrays.asList(stringTab), 4);
        }catch (Exception e){
            Assert.assertTrue(e instanceof PartitionnerException);
            Assert.assertEquals(PartitionnerErrorMessage.INCORRECT_PARTITION_SIZE, e.getMessage());
        }
    }
}
