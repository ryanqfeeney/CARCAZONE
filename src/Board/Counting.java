package Board;
import java.util.ArrayList;
import java.util.Queue;

public class Counting {
	public int CountAnimalsOnGT(BoardSpace root, Coordinates board){
			int count = 0;
		    Queue<BoardSpace> queue = new java.util.LinkedList<BoardSpace>();
		    queue.offer(root);
		    while(!queue.isEmpty()){
		    	BoardSpace node = queue.poll();
		    	if (node.tile.getMiddle() == 4 || node.tile.getMiddle() == 6 || node.tile.getMiddle() == 7){
		    		count++;
		    	}
		        node.AIflag = true;
		        if (node.tile.l.edgeType == 3 && board.left(node).hasTile && !board.left(node).AIflag){
		        	queue.offer(board.left(node));
		        }
		        if (node.tile.t.edgeType == 3 && board.top(node).hasTile && !board.top(node).AIflag){
		        	queue.offer(board.top(node));
		        }
		        if (node.tile.r.edgeType == 3 && board.right(node).hasTile && !board.right(node).AIflag){
		        	queue.offer(board.right(node));
		        }
		        if (node.tile.b.edgeType == 3 && board.bottom(node).hasTile && !board.bottom(node).AIflag){
		        	queue.offer(board.bottom(node));
		        }		        		    
		}
		board.resetFlags();
		return count;
    }
	
	public ArrayList<BoardSpace> FindPotentialSteal(BoardSpace bs, Coordinates board){
		ArrayList<BoardSpace> validMoves = board.getValidSpaces(bs.tile);
		ArrayList<BoardSpace> stealList = new ArrayList<BoardSpace>();
		for (int i = 0; i < validMoves.size(); i++){
			BoardSpace nextValid = validMoves.get(i);
			
			// checks top*right top*left top*bottom
			if (nextValid.tile.t.edgeType == nextValid.tile.r.edgeType
				&& ((board.top(nextValid).tile.hasTiger && board.right(nextValid).tile.hasOppTiger)
					 ||(board.top(nextValid).tile.hasOppTiger && board.right(nextValid).tile.hasTiger))){
				stealList.add(nextValid);		
			}
			if (nextValid.tile.t.edgeType == nextValid.tile.l.edgeType
				&& ((board.top(nextValid).tile.hasTiger && board.left(nextValid).tile.hasOppTiger)
					 ||(board.top(nextValid).tile.hasOppTiger && board.left(nextValid).tile.hasTiger))){
				stealList.add(nextValid);
			}
			if (nextValid.tile.t.edgeType == nextValid.tile.b.edgeType
				&& nextValid.tile.t.edgeType == nextValid.tile.m.edgeType
				&& ((board.top(nextValid).tile.hasTiger && board.bottom(nextValid).tile.hasOppTiger)
					 ||(board.top(nextValid).tile.hasOppTiger && board.bottom(nextValid).tile.hasTiger))){
					stealList.add(nextValid);
			}
			
			// checks right*bottom right*left
			
			if (nextValid.tile.r.edgeType == nextValid.tile.b.edgeType
				&& ((board.right(nextValid).tile.hasTiger && board.bottom(nextValid).tile.hasOppTiger)
					 ||(board.right(nextValid).tile.hasOppTiger && board.bottom(nextValid).tile.hasTiger))){
					stealList.add(nextValid);		
			}
			if (nextValid.tile.r.edgeType == nextValid.tile.l.edgeType
				&& nextValid.tile.r.edgeType == nextValid.tile.m.edgeType
				&& ((board.right(nextValid).tile.hasTiger && board.left(nextValid).tile.hasOppTiger)
					 ||(board.right(nextValid).tile.hasOppTiger && board.left(nextValid).tile.hasTiger))){
					stealList.add(nextValid);
			}
			
			//checks bottom*left
			
			if (nextValid.tile.b.edgeType == nextValid.tile.l.edgeType
				&& ((board.bottom(nextValid).tile.hasTiger && board.left(nextValid).tile.hasOppTiger)
					 ||(board.bottom(nextValid).tile.hasOppTiger && board.left(nextValid).tile.hasTiger))){
					stealList.add(nextValid);		
				}			
		}
		return stealList;
	}
  

}
