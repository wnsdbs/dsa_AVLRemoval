public class MainClass {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.print();
        System.out.println("height = " + avl.height());
        System.out.println();

        AVLTree avlRightRight = new AVLTree();
        Student[] dataRightRight = new Student[20];
        dataRightRight[0] = new Student("Carson", "Freshman", 10);
        dataRightRight[1] = new Student("Chloe", "Senior", 6);
        dataRightRight[2] = new Student("Chris", "Junior", 15);
        dataRightRight[3] = new Student("Cole", "Junior", 4);
        dataRightRight[4] = new Student("Evan", "Freshman", 8);
        dataRightRight[5] = new Student("Abraham", "Sophomore", 12);
        dataRightRight[6] = new Student("Jordan", "Junior", 18);
        dataRightRight[7] = new Student("Justin", "Senior", 2);
        dataRightRight[8] = new Student("Ryan", "Freshman", 5);
        dataRightRight[9] = new Student("Kyle", "Senior", 7);
        dataRightRight[10] = new Student("Luci", "Junior", 11);
        dataRightRight[11] = new Student("Nathan", "Junior", 13);
        dataRightRight[12] = new Student("Karkar", "Freshman", 17);
        dataRightRight[13] = new Student("Rebecca", "Sophomore", 20);
        dataRightRight[14] = new Student("Saad", "Junior", 1);
        dataRightRight[15] = new Student("Souhaib", "Senior", 14);
        dataRightRight[16] = new Student("Zain", "Senior", 16);
        dataRightRight[17] = new Student("Aiden", "Freshman", 19);
        dataRightRight[18] = new Student("Joseph", "Senior", 25);
        dataRightRight[19] = new Student("Ebru", "Junior", 30);

        avlRightRight.insert(dataRightRight);
        avlRightRight.print();
        System.out.println("height = " + avlRightRight.height());
        System.out.println();

        avlRightRight.remove(12);
        avlRightRight.print();
        System.out.println("height = " + avlRightRight.height());
        System.out.println();

        AVLTree avlLeftLeft = new AVLTree();
        Student[] dataLeftLeft = new Student[20];
        dataLeftLeft[0] = new Student("Carson", "Freshman", 15);
        dataLeftLeft[1] = new Student("Chloe", "Senior", 10);
        dataLeftLeft[2] = new Student("Chris", "Junior", 18);
        dataLeftLeft[3] = new Student("Cole", "Junior", 6);
        dataLeftLeft[4] = new Student("Evan", "Freshman", 13);
        dataLeftLeft[5] = new Student("Abraham", "Sophomore", 16);
        dataLeftLeft[6] = new Student("Jordan", "Junior", 20);
        dataLeftLeft[7] = new Student("Justin", "Senior", 4);
        dataLeftLeft[8] = new Student("Ryan", "Freshman", 7);
        dataLeftLeft[9] = new Student("Kyle", "Senior", 12);
        dataLeftLeft[10] = new Student("Luci", "Junior", 14);
        dataLeftLeft[11] = new Student("Nathan", "Junior", 17);
        dataLeftLeft[12] = new Student("Karkar", "Freshman", 19);
        dataLeftLeft[13] = new Student("Rebecca", "Sophomore", 25);
        dataLeftLeft[14] = new Student("Saad", "Junior", 2);
        dataLeftLeft[15] = new Student("Souhaib", "Senior", 5);
        dataLeftLeft[16] = new Student("Zain", "Senior", 8);
        dataLeftLeft[17] = new Student("Aiden", "Freshman", 11);
        dataLeftLeft[18] = new Student("Joseph", "Senior", 30);
        dataLeftLeft[19] = new Student("Ebru", "Junior", 1);

        avlLeftLeft.insert(dataLeftLeft);
        avlLeftLeft.print();
        System.out.println("height = " + avlLeftLeft.height());
        System.out.println();

        avlLeftLeft.remove(13);
        avlLeftLeft.print();
        System.out.println("height = " + avlLeftLeft.height());
        System.out.println();

        AVLTree avlRightLeft = new AVLTree();
        Student[] dataRightLeft = new Student[22];
        dataRightLeft[0] = new Student("Carson", "Freshman", 15);
        dataRightLeft[1] = new Student("Chloe", "Senior", 6);
        dataRightLeft[2] = new Student("Chris", "Junior", 20);
        dataRightLeft[3] = new Student("Cole", "Junior", 4);
        dataRightLeft[4] = new Student("Evan", "Freshman", 11);
        dataRightLeft[5] = new Student("Abraham", "Sophomore", 17);
        dataRightLeft[6] = new Student("Jordan", "Junior", 29);
        dataRightLeft[7] = new Student("Justin", "Senior", 2);
        dataRightLeft[8] = new Student("Ryan", "Freshman", 5);
        dataRightLeft[9] = new Student("Kyle", "Senior", 8);
        dataRightLeft[10] = new Student("Luci", "Junior", 13);
        dataRightLeft[11] = new Student("Nathan", "Junior", 16);
        dataRightLeft[12] = new Student("Karkar", "Freshman", 18);
        dataRightLeft[13] = new Student("Rebecca", "Sophomore", 25);
        dataRightLeft[14] = new Student("Saad", "Junior", 30);
        dataRightLeft[15] = new Student("Souhaib", "Senior", 1);
        dataRightLeft[16] = new Student("Zain", "Senior", 7);
        dataRightLeft[17] = new Student("Aiden", "Freshman", 10);
        dataRightLeft[18] = new Student("Joseph", "Senior", 14);
        dataRightLeft[19] = new Student("Ebru", "Junior", 19);
        dataRightLeft[20] = new Student("Elena", "Junior", 33);
        dataRightLeft[21] = new Student("Eva", "Freshman", 9);

        avlRightLeft.insert(dataRightLeft);
        avlRightLeft.print();
        System.out.println("height = " + avlRightLeft.height());
        System.out.println();

        avlRightLeft.remove(1);
        avlRightLeft.print();
        System.out.println("height = " + avlRightLeft.height());
        System.out.println();

        AVLTree avlLeftRight = new AVLTree();
        Student[] dataLeftRight = new Student[22];
        dataLeftRight[0] = new Student("Carson", "Freshman", 15);
        dataLeftRight[1] = new Student("Chloe", "Senior", 6);
        dataLeftRight[2] = new Student("Chris", "Junior", 20);
        dataLeftRight[3] = new Student("Cole", "Junior", 4);
        dataLeftRight[4] = new Student("Evan", "Freshman", 11);
        dataLeftRight[5] = new Student("Abraham", "Sophomore", 17);
        dataLeftRight[6] = new Student("Jordan", "Junior", 29);
        dataLeftRight[7] = new Student("Justin", "Senior", 2);
        dataLeftRight[8] = new Student("Ryan", "Freshman", 5);
        dataLeftRight[9] = new Student("Kyle", "Senior", 8);
        dataLeftRight[10] = new Student("Luci", "Junior", 13);
        dataLeftRight[11] = new Student("Nathan", "Junior", 16);
        dataLeftRight[12] = new Student("Karkar", "Freshman", 18);
        dataLeftRight[13] = new Student("Rebecca", "Sophomore", 25);
        dataLeftRight[14] = new Student("Saad", "Junior", 30);
        dataLeftRight[15] = new Student("Souhaib", "Senior", 1);
        dataLeftRight[16] = new Student("Zain", "Senior", 7);
        dataLeftRight[17] = new Student("Aiden", "Freshman", 10);
        dataLeftRight[18] = new Student("Joseph", "Senior", 14);
        dataLeftRight[19] = new Student("Ebru", "Junior", 19);
        dataLeftRight[20] = new Student("Elena", "Junior", 33);
        dataLeftRight[21] = new Student("Eva", "Freshman", 9);

        avlLeftRight.insert(dataLeftRight);
        avlLeftRight.print();
        System.out.println("height = " + avlLeftRight.height());
        System.out.println();

        avlLeftRight.remove(13);
        avlLeftRight.print();
        System.out.println("height = " + avlLeftRight.height());
        System.out.println();
    }
    
    /*
There are no nodes in the tree.
height = -1

Id:  10    Name: Carson    Class:  Freshman
Id:   6    Name:  Chloe    Class:    Senior
Id:  15    Name:  Chris    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:   8    Name:   Evan    Class:  Freshman
Id:  12    Name: Abraham    Class: Sophomore
Id:  18    Name: Jordan    Class:    Junior
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   7    Name:   Kyle    Class:    Senior
Id:  11    Name:   Luci    Class:    Junior
Id:  13    Name: Nathan    Class:    Junior
Id:  17    Name: Karkar    Class:  Freshman
Id:  20    Name: Rebecca    Class: Sophomore
Id:   1    Name:   Saad    Class:    Junior
Id:  14    Name: Souhaib    Class:    Senior
Id:  16    Name:   Zain    Class:    Senior
Id:  19    Name:  Aiden    Class:  Freshman
Id:  25    Name: Joseph    Class:    Senior
Id:  30    Name:   Ebru    Class:    Junior
height = 5

Id:  10    Name: Carson    Class:  Freshman
Id:   6    Name:  Chloe    Class:    Senior
Id:  18    Name: Jordan    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:   8    Name:   Evan    Class:  Freshman
Id:  15    Name:  Chris    Class:    Junior
Id:  20    Name: Rebecca    Class: Sophomore
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   7    Name:   Kyle    Class:    Senior
Id:  13    Name: Nathan    Class:    Junior
Id:  17    Name: Karkar    Class:  Freshman
Id:  19    Name:  Aiden    Class:  Freshman
Id:  25    Name: Joseph    Class:    Senior
Id:   1    Name:   Saad    Class:    Junior
Id:  11    Name:   Luci    Class:    Junior
Id:  14    Name: Souhaib    Class:    Senior
Id:  16    Name:   Zain    Class:    Senior
Id:  30    Name:   Ebru    Class:    Junior
height = 4

Id:  15    Name: Carson    Class:  Freshman
Id:  10    Name:  Chloe    Class:    Senior
Id:  18    Name:  Chris    Class:    Junior
Id:   6    Name:   Cole    Class:    Junior
Id:  13    Name:   Evan    Class:  Freshman
Id:  16    Name: Abraham    Class: Sophomore
Id:  20    Name: Jordan    Class:    Junior
Id:   4    Name: Justin    Class:    Senior
Id:   7    Name:   Ryan    Class:  Freshman
Id:  12    Name:   Kyle    Class:    Senior
Id:  14    Name:   Luci    Class:    Junior
Id:  17    Name: Nathan    Class:    Junior
Id:  19    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:   2    Name:   Saad    Class:    Junior
Id:   5    Name: Souhaib    Class:    Senior
Id:   8    Name:   Zain    Class:    Senior
Id:  11    Name:  Aiden    Class:  Freshman
Id:  30    Name: Joseph    Class:    Senior
Id:   1    Name:   Ebru    Class:    Junior
height = 5

Id:  15    Name: Carson    Class:  Freshman
Id:   6    Name:   Cole    Class:    Junior
Id:  18    Name:  Chris    Class:    Junior
Id:   4    Name: Justin    Class:    Senior
Id:  10    Name:  Chloe    Class:    Senior
Id:  16    Name: Abraham    Class: Sophomore
Id:  20    Name: Jordan    Class:    Junior
Id:   2    Name:   Saad    Class:    Junior
Id:   5    Name: Souhaib    Class:    Senior
Id:   7    Name:   Ryan    Class:  Freshman
Id:  12    Name:   Kyle    Class:    Senior
Id:  17    Name: Nathan    Class:    Junior
Id:  19    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:   1    Name:   Ebru    Class:    Junior
Id:   8    Name:   Zain    Class:    Senior
Id:  11    Name:  Aiden    Class:  Freshman
Id:  14    Name:   Luci    Class:    Junior
Id:  30    Name: Joseph    Class:    Senior
height = 4

Id:  15    Name: Carson    Class:  Freshman
Id:   6    Name:  Chloe    Class:    Senior
Id:  20    Name:  Chris    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:  11    Name:   Evan    Class:  Freshman
Id:  17    Name: Abraham    Class: Sophomore
Id:  29    Name: Jordan    Class:    Junior
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   8    Name:   Kyle    Class:    Senior
Id:  13    Name:   Luci    Class:    Junior
Id:  16    Name: Nathan    Class:    Junior
Id:  18    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:  30    Name:   Saad    Class:    Junior
Id:   1    Name: Souhaib    Class:    Senior
Id:   7    Name:   Zain    Class:    Senior
Id:  10    Name:  Aiden    Class:  Freshman
Id:  14    Name: Joseph    Class:    Senior
Id:  19    Name:   Ebru    Class:    Junior
Id:  33    Name:  Elena    Class:    Junior
Id:   9    Name:    Eva    Class:  Freshman
height = 5

Id:  15    Name: Carson    Class:  Freshman
Id:   8    Name:   Kyle    Class:    Senior
Id:  20    Name:  Chris    Class:    Junior
Id:   6    Name:  Chloe    Class:    Senior
Id:  11    Name:   Evan    Class:  Freshman
Id:  17    Name: Abraham    Class: Sophomore
Id:  29    Name: Jordan    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:   7    Name:   Zain    Class:    Senior
Id:  10    Name:  Aiden    Class:  Freshman
Id:  13    Name:   Luci    Class:    Junior
Id:  16    Name: Nathan    Class:    Junior
Id:  18    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:  30    Name:   Saad    Class:    Junior
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   9    Name:    Eva    Class:  Freshman
Id:  14    Name: Joseph    Class:    Senior
Id:  19    Name:   Ebru    Class:    Junior
Id:  33    Name:  Elena    Class:    Junior
height = 4

Id:  15    Name: Carson    Class:  Freshman
Id:   6    Name:  Chloe    Class:    Senior
Id:  20    Name:  Chris    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:  11    Name:   Evan    Class:  Freshman
Id:  17    Name: Abraham    Class: Sophomore
Id:  29    Name: Jordan    Class:    Junior
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   8    Name:   Kyle    Class:    Senior
Id:  13    Name:   Luci    Class:    Junior
Id:  16    Name: Nathan    Class:    Junior
Id:  18    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:  30    Name:   Saad    Class:    Junior
Id:   1    Name: Souhaib    Class:    Senior
Id:   7    Name:   Zain    Class:    Senior
Id:  10    Name:  Aiden    Class:  Freshman
Id:  14    Name: Joseph    Class:    Senior
Id:  19    Name:   Ebru    Class:    Junior
Id:  33    Name:  Elena    Class:    Junior
Id:   9    Name:    Eva    Class:  Freshman
height = 5

Id:  15    Name: Carson    Class:  Freshman
Id:   6    Name:  Chloe    Class:    Senior
Id:  20    Name:  Chris    Class:    Junior
Id:   4    Name:   Cole    Class:    Junior
Id:  10    Name:  Aiden    Class:  Freshman
Id:  17    Name: Abraham    Class: Sophomore
Id:  29    Name: Jordan    Class:    Junior
Id:   2    Name: Justin    Class:    Senior
Id:   5    Name:   Ryan    Class:  Freshman
Id:   8    Name:   Kyle    Class:    Senior
Id:  11    Name:   Evan    Class:  Freshman
Id:  16    Name: Nathan    Class:    Junior
Id:  18    Name: Karkar    Class:  Freshman
Id:  25    Name: Rebecca    Class: Sophomore
Id:  30    Name:   Saad    Class:    Junior
Id:   1    Name: Souhaib    Class:    Senior
Id:   7    Name:   Zain    Class:    Senior
Id:   9    Name:    Eva    Class:  Freshman
Id:  14    Name: Joseph    Class:    Senior
Id:  19    Name:   Ebru    Class:    Junior
Id:  33    Name:  Elena    Class:    Junior
height = 4
     */
}

 

