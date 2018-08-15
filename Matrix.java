
public class Matrix {
//a)
	public static int[][] readMatrix(String[] s)
	{
		String w = s[0];
		char c =w.charAt(0);
		int length = c-'0';
		int row=0;
		int column=0;
		 int [][] matrix =new int [length][length];
		 for(int j =1;j<s.length;j++)
		 {
			 String e = s[j];
			 char el = s[j].charAt(0);
			 int elementmatrix =el-'0';
			 if(column<length)
			 {
				 matrix[row][column]=elementmatrix;
				 column++;
			 }
			 else
			 {
				 column=0;
				 row++;
				 matrix[row][column]=elementmatrix;
			 }
			 
			 
		 }
		 return matrix;
	}
	//b)
	public static String toString(int[][] m)
	{
		String matrix = null;
		for(int i=0;i<m.length;i++)
		{
			matrix+="[";
			for(int j=0;j<m.length;j++)
			{
				matrix+=m[i][j]+" "+",";
				
			}
			matrix+="]";
			matrix+="/n";
		}
		return matrix;
	}
	//c)
	public static int[][] matrixAdd(int[][] a, int[][] b)
	{
		int [][] add = new int [a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				add[i][j] = a[i][j]+b[i][j];
			}
		}
		return add;
			
	}
	//d)
	public static int[][] matrixMultiply(int[][] a, int[][] b)
	{
		int  [][] matrixMultiply = new int [a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				matrixMultiply[i][j]=a[i][j]+b[i][j];
			}
		}
		return matrixMultiply;
		
	}
	//e)
	public static int [][] matrixTranspose(int[][] a)
	{
		int [][] matrixTranspose = new int [a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				matrixTranspose[i][j]=a[j][i];
			}
		}
		return matrixTranspose;
	}
	//f)
	public static void main( String[] args)
	{
		int length = Integer.parseInt(args[0]);
		String [] a =null;
		String [] b =null;
		String [] c =null;
		int k=0;
		for(int i=1;i<=length+1;i++)
		{
			a[k]=args[i];
			
		}
		int p=0;
		for(int j=length+2;j<=2*length+1;j++)
		{
			b[k]=args[j];
			k++;
		}
		int m =0;
		for(int v =2*length+2;v<=3*length+1;v++)
		{
			c[m]=args[v];
			m++;
		}
	
	int [][] ma =readMatrix(a);
	int [][] mb =readMatrix(b);
	int [][] mc =readMatrix(c);
	System.out.println(matrixAdd(ma,mb).toString());
	System.out.println(matrixMultiply(ma,mb).toString());
	System.out.println(matrixMultiply(mc,matrixAdd(ma,mb)));
	System.out.println(matrixAdd(matrixMultiply(ma,mb),matrixMultiply(ma,mc)));
	System.out.println(matrixTranspose(matrixMultiply(ma,mb)));
	System.out.println(matrixAdd(matrixTranspose(ma),matrixTranspose(mb)));
	}
	
}
