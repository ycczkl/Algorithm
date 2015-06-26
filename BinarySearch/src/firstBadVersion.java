/**
The code base version is an integer and start from 1 to n.
One day, someone commit a bad version in the code case,
so it caused itself and the following versions are all failed in the unit tests.
*/

public class firstBadVersion {
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
	//本质是有序的一维boolean数组，二分查找适用
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n <= 0)
            return 0;
        int s = 1;
        int e = n;
        while (s+1<e) {
            int mid = (s+e)/2;
            boolean value = VersionControl.isBadVersion(mid);
            if (value == true) {
                e = mid;
            } else {
                s = mid;
            }
        }
        if (VersionControl.isBadVersion(s) == true) {
            return s;
        } else if (VersionControl.isBadVersion(e) == true) {
            return e;
        } 
        return 0;
    }
}
