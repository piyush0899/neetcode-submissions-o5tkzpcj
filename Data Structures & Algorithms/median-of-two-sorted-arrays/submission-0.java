class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i = 0, j = 0;
      
        // m1 to store the middle element
        // m2 to store the second middle element
        int m1 = -1, m2 = -1;

        // loop till (m + n)/2
        for (int count = 0; count <= (m + n)/2; count++){
            m2 = m1;
          
            // if both the arrays have remaining elements
            if (i != n && j != m)
                m1 = (a[i] > b[j]) ? b[j++] : a[i++];
            
            // if only a[] has remaining elements
            else if (i < n) 
                m1 = a[i++];
          
            // if only b[] has remaining elements
            else 
                m1 = b[j++];
        }

        // return median based on odd/even size
        if ((m + n) % 2 == 1) 
            return m1;
        else
            return (m1 + m2) / 2.0;
    }
}
