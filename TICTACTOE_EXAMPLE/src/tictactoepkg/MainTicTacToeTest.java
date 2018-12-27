package tictactoepkg;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTicTacToeTest {

	MainTicTacToe  tictac=new MainTicTacToe();
	String[] board;

	
	@Test
	public void testCheckWinnerForX() {	
		
		board = new String[]{"X","X","X","0","X","0","0","X","9"};
		
		assertEquals("X",tictac.checkWinner(board));
		
	board = new String[]{"0","0","0","X","0","X","X","0","9"};
		
		assertEquals("0",tictac.checkWinner(board));
		
   board = new String[]{"0","X","0","X","0","X","X","0","X"};
		
		assertEquals("draw",tictac.checkWinner(board));
		 	

	}
	

}
