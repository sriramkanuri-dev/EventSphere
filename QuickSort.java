import java.util.*;

public class QuickSort {

    static void sort(
            int[] a,
            int l,
            int h){

        if(l<h){

            int p=
                    partition(a,l,h);

            sort(a,l,p-1);
            sort(a,p+1,h);
        }
    }

    static int partition(
            int[] a,
            int l,
            int h){

        int pivot=a[h];
        int i=l-1;

        for(int j=l;j<h;j++){

            if(a[j]>pivot){

                i++;

                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }

        int t=a[i+1];
        a[i+1]=a[h];
        a[h]=t;

        return i+1;
    }

    public static void main(
            String[] args){

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Events: ");
            int n=sc.nextInt();

            int[] a=
                    new int[n];

            for(int i=0;i<n;i++){

                System.out.print(
                        "Registrations: "
                );

                a[i]=sc.nextInt();
            }

            sort(a,0,n-1);

            for(int x:a)
                System.out.println(x);
        }
    }
}