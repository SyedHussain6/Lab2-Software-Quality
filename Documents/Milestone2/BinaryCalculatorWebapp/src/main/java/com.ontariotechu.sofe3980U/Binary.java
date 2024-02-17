package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	//Binary mulitiplication
	public static Binary multiplying(Binary num1,Binary num2)

	{
		//Index of the first digit of each num 
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;

		//initial variable
		int carry=0;
		String num3=""; //binary result

		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int prod=carry; // initialize product to carry 
			if(ind1>=0){ 

				prod += (num1.number.charAt(ind1) == '1') ? 1 : 0; // add digit from first number 
            	ind1--; //next digit
			}
			if(ind2>=0){ // if num2 has a digit to add
				prod += (num2.number.charAt(ind2) == '1') ? 1 : 0; // add digit from second number  
            	ind2--; //next digit
			}

			carry=prod/2; // the new carry
			prod=prod%2;  // calculate the current digit
			num3 =( (prod==0)? "0":"1")+num3; //appending current digit to the num3 
		}

		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}

	//Binary bitwise AND
	public static Binary bitwiseAND(Binary num1,Binary num2)

	{
		//Index of the first digit of each num 
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;

		//initial variable
		String num3="";  //binary result 

		while(ind1>=0 ||  ind2>=0) // loop until all digits are processed

		{

			if (num1.number.charAt(ind1) == '1' && num2.number.charAt(ind2) == '1') {
				num3 = "1" + num3; // set result digit to 1 if both are 1 
			} else {
				num3 = "0" + num3; // set to 0 if other condition not met 
			}

        ind1--; //go to next digit in first number
        ind2--; //go to next digit in second number

		}

		
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}


	//Binary bitwise or
	public static Binary bitwiseOR(Binary num1, Binary num2) {

    //Index of the first digit of each num 
    int ind1 = num1.number.length() - 1;
    int ind2 = num2.number.length() - 1;

    //initial variable
    String num3 = "";  // the binary value of the sum

    while (ind1 >= 0 || ind2 >= 0) { // loop until all digits are processed
        if (ind1 >= 0 && ind2 >= 0) { // corrected variable names here
            if (num1.number.charAt(ind1) == '1' || num2.number.charAt(ind2) == '1') {
                num3 = "1" + num3; // result digit to 1 if either are 1 
            } else {
                num3 = "0" + num3; // otherwise set result digit to 0 
            }
        } else if (ind1 >= 0) {
            num3 = num1.number.charAt(ind1) + num3; // appending remaining digits from first number 
        } else {
            num3 = num2.number.charAt(ind2) + num3;  // appending remaining digits from second number 
        }
		
        ind1--; // move to next digit in first number 
        ind2--; // move to the next digit in second number 
    }
    Binary result = new Binary(num3);  // create a binary object with the calculated value.
    return result;
}




	
}	
