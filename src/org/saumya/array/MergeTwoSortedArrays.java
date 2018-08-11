package org.saumya.array;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[]={1,2,8,5};
        int arr2[]={3,7,9};
        int n1=arr1.length;
        int n2=arr2.length;
        int arr3[]=new int[n1+n2];
        mergeArrays(arr1,arr2,arr3);
        for(int i=0;i<n1+n2;i++) {
            System.out.println(" "+arr3[i]);
        }
        }




    public static void mergeArrays(int arr1[],int arr2[],int arr3[]){
        int i=0,k=0,j=0;
        while(i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {

                arr3[k++] = arr2[j++];

            }
        }
            while(i<arr1.length)
                arr3[k++]=arr1[i++];
            while(j<arr2.length)
                arr3[k++]=arr2[j++];


        }

    }

