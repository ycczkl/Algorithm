public class strStr {
	// 计算rolling hash需要注意从后向前计算，同时需要计算tmpBase的值	
	public static int strStr(String source, String target) {
        if (target.length() > source.length())
            return -1;
        int base = 29;
        long tmpBase = 1;
        long targetHash = 0;
        long sourceHash = 0;
        for (int i = target.length()-1; i >= 0; i--) {
            tmpBase *= base;
            targetHash = targetHash * base + (int)target.charAt(i);            
            sourceHash = sourceHash * base + (int)source.charAt(i);
        }
        tmpBase /= base;
        
        if (targetHash == sourceHash)
            return 0;
        
        System.out.println(targetHash);
        for (int i = target.length(); i < source.length(); i++) {            
            sourceHash = (sourceHash-(int)source.charAt(i-target.length()))/base + source.charAt(i)*tmpBase;
            System.out.println(sourceHash);
            if (targetHash == sourceHash)
                return i - target.length()+1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("abcd", "bcd"));
	}
}
