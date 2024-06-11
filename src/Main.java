import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        for(int j=1;j<=slen;j++){
            if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        optionsSelection();

                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int length = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        
        //Complete the method
        // Search for the expense entered by the user in the arrayList and print the result.

        Scanner sc = new Scanner(System.in);
        int search = sc.nextInt();
        if(arrayList.contains(search)){
            System.out.println("Expense found: "+search);
        }else{
            System.out.println("Expense not found: "+search);
        }



    }
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
       //Complete the method. The expenses should be sorted in ascending order.

       // Sort expenses in ascending order using mergesort
        mergeSort(arrayList, 0, arrlength-1);
        System.out.println("Expenses in ascending order: "+arrayList);

    }

    private static void mergeSort(ArrayList<Integer> arrayList, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arrayList, l, m);
            mergeSort(arrayList, m+1, r);
            merge(arrayList, l, m, r);
        }
    }

    private static void merge(ArrayList<Integer> arrayList, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; i++){
            L[i] = arrayList.get(l+i);
        }
        for(int j=0; j<n2; j++){
            R[j] = arrayList.get(m+1+j);
        }

        int i=0, j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arrayList.set(k, L[i]);
                i++;
            }else{
                arrayList.set(k, R[j]);
                j++;
            }
            k++;
        }

        while(i<n1){
            arrayList.set(k, L[i]);
            i++;
            k++;
        }

        while(j<n2){
            arrayList.set(k, R[j]);
            j++;
            k++;
        }
    }
}
