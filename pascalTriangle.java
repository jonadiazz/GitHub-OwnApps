import java.util.Scanner;
//import java.util.InputMismatchException;
import java.util.*;


public class pascalTriangle
{
    public static void main (String [] args)
    {
        pascalTriangle pT = new pascalTriangle();

        Scanner input = new Scanner(System.in);
        String pascalRowMismatch = "";
        int pascalRow = 0;
        boolean bool = true;
        do 
        {
            System.out.print("\nWhich row coefficients of the Pascal triangle do you want to show? (if you want to exit input -1) ");
            try
            {
                pascalRow = input.nextInt();
                if(pascalRow == -1)
                {
                    bool = false;
                    System.out.println();
                }
                else
                {
                    System.out.println(pascalRow);
                    pT.showCoefficients(pascalRow);
                }
            }
            catch(InputMismatchException e)
            {
                String.format("Try an integer row next time - I dont remember we could count rows by other than integers -_-\n");
                input.nextLine();
            }
        } while(bool);

    }
    public void giveZeros(int arr[][])
    {
        for(int i=0; i<arr.length; i++)
        {
            for (int j =0; j<arr[i].length; j++)
            {
                arr[i][j] = 0; 
            }
        }

    }
    public void showCoefficients(int row)
    {
        int array[][]; 
        int initPosCol = -1;
        if(row%2 != 0) //   if odd
        {
            array = new int[row+1][row+2];
        } 
        else // if even
        {
            array = new int[row+1][row+3];
        }
        //array = new int[row+1][row+1];
        System.out.println("array[].length: " + array[0].length + "\narray.length: " + array.length);

        initPosCol = array[0].length/2;
        giveZeros(array);

        array[0][initPosCol] = 1;

        for(int i = 0;  i <= row; i++)
        {
            if(i == 1)
            {
                array[1][initPosCol-1] = 1;
                array[1][initPosCol+1] = 1;
            }
            else if(i == 0)
            {
                //do nothing
            }
            else if(i%2 != 0) //  if is odd number for row
            {
                array[i][initPosCol-1] = array[i-1][initPosCol-1] + array[i-1][initPosCol];
                array[i][initPosCol+1] = array[i-1][initPosCol+1] + array[i-1][initPosCol];
                for(int k = 2; k <= ((i/2)+1); k++)
                {
                    array[i][initPosCol-k] = array[i-1][initPosCol-k] + array[i-1][initPosCol-k+1];
                    array[i][initPosCol+k] = array[i-1][initPosCol+k] + array[i-1][initPosCol+k-1];
                }
            }
            else if(i%2 == 0) // if is even number for row
            {
                array[i][initPosCol] = array[i-1][initPosCol-1] + array[i-1][initPosCol+1];
                for(int x = 1; x <= (i/2); x++)
                {
                    array[i][initPosCol+x] = array[i-1][initPosCol+x] + array[i-1][initPosCol+x+1];
                    array[i][initPosCol-x] = array[i-1][initPosCol-x] + array[i-1][initPosCol-x-1];
                }
            }
        }
        for(int t=0; t<array.length; t++)
        {
            System.out.print("\t\t\t");
            for (int j =0; j<array[t].length; j++)
            {
                    System.out.print(array[t][j]+ " ");
            }
            System.out.println();
        }
    }
}
