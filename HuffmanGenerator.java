import listrefbase.*;
import java.io.*;
import static java.lang.Integer.parseInt;

public class HuffmanGenerator {
    protected ListArrayBased table = new ListArrayBased();
    protected TreeNode head;
    protected String code = "";
    File file;
    HuffmanGenerator(File file){
        this.file = file;
        settablearray();
        creatTree();
    }
    public void settablearray(){
        try {
            String data = "";
            String [] sliptdata = new String[2];
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int i= 1;
            while (data != null){
                data = reader.readLine();
                if(data != null) {
                    sliptdata = data.split(",");
                    table.add(i, new TreeNode(sliptdata[0].charAt(0), parseInt(sliptdata[1])));
                }
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //creat the treenode
    public void creatTree(){
        //giving left a value becuase left must no be null for the while loop to be true
        TreeNode left = table.get(1);
        TreeNode right;
        char specialsymbol = '*';
        int i =0;
        while (left !=null) {
            // remove in the treenode class i added a line to return the items that was remove
            //setting left and right to those value
            left = table.remove(1);
            right = table.remove(1);
            if (left !=null && right !=null) {
                //set head to new node with special symbol and for the freequancy im adding left anf right
                head = new TreeNode(specialsymbol, left.getFrequency() + right.getFrequency());
                //after setting left and right as child of head
                head.setLeft(left);
                head.setRight(right);
                //adding it back to the array
                table.add(1, head);
            }
            i++;
        }
    }
    //encode a char
    public void encodeChar (TreeNode root,String codes,char c){
        //while root is no null we keep going
        if(root !=null){
            //if found symbol set the code to the global variable code
            if(root.getSymbol() == c){
                code = codes;
            }
            //call itself but add 0 to the code if we go left and 1 if we go right
            encodeChar(root.getLeft(),codes+"0",c);
            encodeChar(root.getRight(),codes+"1",c);
        }
    }
    //this code call the encodeChar for each char in the string using a for loop
    public String encodeString(String text){
        String stringcode = "";
        //calling encode codechar with all the char in a string text
        for(int i =0;i< text.length();i++){
            encodeChar(head,"",text.charAt(i));
            //storing all code in a new variable
            stringcode = stringcode + code;
        }
        return stringcode;
    }
    //decode string and char
    public String decode(TreeNode root,String codes){
        int i = 0;
        //this where the decoded text will be stored
        String decodetext = "";
        TreeNode parent = root;
        //while your not at the end of the string
        while (i<codes.length()){
			//this variable will be later use get the parrent node of null node
            parent = root;
            //if it 0 we get left else get right
            if(codes.charAt(i) == '0'){
                root = root.getLeft();
            }
            else {
                root = root.getRight();
            }
            if(root == null){
				//if root == null we get the parent
                decodetext = decodetext + parent.getSymbol();
                // if root == null means we found one letter set root back to head for the next iteration to decode the next char
                root = head;
            }
            else {
                if(i == codes.length()-1){
					//this checks to see if the last symbol is * if it is it mean the code is wrong so it will retrun a error the main program
					if(root.getSymbol() == '*'){
                    	 return "INVALID CODE PLEASE CHECK YOUR CODE AND TRY AGAIN";
					}
					else{
						decodetext = decodetext + root.getSymbol();
					}
				}
                i++;
            }

        }
        return decodetext;
    }
    //get method for the head node
    public TreeNode getHead() {
        return head;
    }
}
