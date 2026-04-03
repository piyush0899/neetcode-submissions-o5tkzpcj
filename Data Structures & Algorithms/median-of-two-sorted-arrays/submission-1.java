class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int n1 = a.length;
        int n2 = b.length;
        int n = n1+n2;
        int index1 = n/2;
        int index2 = index1 -1;
        int count = 0;
        int el1 = -1;
        int el2 = -1;

        while(i<n1 && j<n2){
            
            if(a[i]<b[j]){
                
                if(count == index1) el1 = a[i];
                if(count == index2) el2 = a[i]; 
                count++;
                i++;
            }
            else{
               
                if(count == index1) el1 = b[j];
                if(count == index2) el2 = b[j]; 
                 count++;
                j++;
            }

        }
        while(i<n1){
            if(count == index1) el1 = a[i];
            if(count == index2) el2 = a[i]; 
            i++;
            count++;
        }
        while(j<n2){
            if(count == index1) el1 = b[j];
            if(count == index2) el2 = b[j]; 
            j++;
            count++;
        }

        if(n%2 != 0){
            return el1;
        } 
        else{
            return (double)(el1+el2)/2;
        }
}
}