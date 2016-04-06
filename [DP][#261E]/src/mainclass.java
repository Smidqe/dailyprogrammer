public class mainclass {
	
	public static String print2DArray(Integer[][] values)
	{
		StringBuilder builder = new StringBuilder();
		
		for (int y = 0; y < values.length; y++)
		{
			for (int x = 0; x < values[y].length; x++)
				builder.append(values[y][x] + " ");
		
			builder.append('\n');
		}
		
		return builder.toString();
	}
	
	public static boolean isMagicSquare(Integer[][] values)
	{
		int x = 0, y = 0, row = 0, column = 0, diagonal = 0;

		while (y < values.length && x < values[y].length)
		{
			//We assume that the form is actually a square and not rectangle
			if ((y == 0 || y == values.length - 1) && x == 0) 
			{
				diagonal = 0;
				
				int direction = (y == values.length - 1) ? -1 : 1;
				
				for (int offset = 0; offset < values.length; offset++)
					diagonal += values[y + offset * direction][x + offset];
			}

			if (y == 0)
			{
				column = 0;
				for (int i = 0; i < values.length; i++)
					column += values[y + i][x];
			}

			if (x == 0)
			{
				row = 0;
				for (int i = 0 ; i < values.length; i++)
					row += values[y][x + i];
			}
			
			if (!(row == column && column == diagonal && row == diagonal))
				return false;
			
			//Check if we need to increase the y-coordinate (switch to another row)
			y += (x == values.length - 1) ? 1 : 0;
			x = ((((x % (values.length - 1)) == 0) && x != 0) ? 0 : x + 1); 
		}
			
		return true;
	}

	public static void main(String[] args) {
		//3x3
		Integer[][] grid1 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}; 
		Integer[][] grid2 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
		Integer[][] grid3 = {{3, 5, 7}, {8, 1, 6}, {4, 9, 2}};
		Integer[][] grid4 = {{8, 1, 6}, {7, 5, 3}, {4, 9, 2}};
		
		//4x4
		Integer[][] grid5 = {{4, 14, 15, 1}, {9, 7, 6, 12}, {5, 11, 10, 8}, {16, 2, 3, 13}};
		
		
		print2DArray(grid1);
		
		System.out.println("Examples:");
		System.out.println(print2DArray(grid1) + "Result -> " + isMagicSquare(grid1) + "\n");
		System.out.println(print2DArray(grid2) + "Result -> " + isMagicSquare(grid2) + "\n");
		System.out.println(print2DArray(grid3) + "Result -> " + isMagicSquare(grid3) + "\n");
		System.out.println(print2DArray(grid4) + "Result -> " + isMagicSquare(grid4) + "\n");
		
		System.out.println("Bonus 1:");
		System.out.println(print2DArray(grid5) + "Result -> " + isMagicSquare(grid5) + "\n");
	}

}
