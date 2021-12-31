package lambda_expression;

public class Lambda_Expression {
    
    
    // Better String Function
    public static String return_betterString(String str1, String str2, betterStringInterface Obj)
    {
        if (Obj.Check_betterString(str1, str2))
            return str1;
        else
            return str2;
    }
    
    public static void main(String[] args) {

        //Task 1
        String x = "Beautiful Task";
        String y = "Hello World";
        
        String better_upon_length = Lambda_Expression.return_betterString(x, y, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Task 1 Result: ");
        System.out.println("The Better String is : " + better_upon_length);
        
        System.out.println("    *   *   *   ");
        

        //Task 2
        
        OnlyAlphabets helpfulObj = (str) -> {
            
            boolean result = true;
            int flag = 1;

            while (result & flag <= str.length())
            {
                for (int i = 0; i < str.length(); i ++)
                {
                    
                    if (Character.isLetter(str.charAt(i)))
                        flag++;

                     else
                    {result = false;
                      break;}
                }
            }
                
             
            if (result)
                    System.out.println("\"" + str + "\" : contains only alphabets");
            else
                    System.out.println("\"" + str + "\" : string contains alphabets and others ... ");    
                
            return;
            };
        
    
        
        String teststr1 = "Java";
        String teststr2 = "Wssam_Hassan";
       System.out.println("Task 2 Result: ");
        helpfulObj.check_islphabets(teststr1);
        helpfulObj.check_islphabets(teststr2);

    }
    
}
