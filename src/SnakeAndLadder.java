/**
 * Created by Admin on 30-08-2017.
 */
import com.sun.org.apache.bcel.internal.generic.LADD;

import java.util.*;

/**
 * Created by Admin on 30-08-2017.
 */
public class SnakeAndLadder {

    private Node start;

    public void setUp()
    {
        for(int index = 1 ; index <= 100 ; index++)
        {
            insert(new Integer(index));
        }

        Map<Integer,Integer> snakeMap = new HashMap();
        Map<Integer,Integer> ladderMap = new HashMap();

        snakeMap.put(98,2);
        snakeMap.put(90,11);
        snakeMap.put(81,27);
        snakeMap.put(66,35);
        snakeMap.put(51,43);

        ladderMap.put(3,99);
        ladderMap.put(11,72);
        ladderMap.put(21,58);
        ladderMap.put(34,68);
        ladderMap.put(43,59);

        insertSnakesAndLadders(snakeMap,ladderMap);
    }

    public void playGame()
    {
        Node currentNode = start;
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Roll the dice: (y/n)");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("y")) {
                int random = (int) (Math.random() * 6 + 1);
                System.out.println("Dice number = "+random);
                for(int index = 0; index < random ; index++)
                {
                    if(!Objects.isNull(currentNode.getLink())) {
                        currentNode = currentNode.getLink();
                    }
                }
                System.out.println("Position = "+currentNode.getData().toString());
                if(!Objects.isNull(currentNode.getSnake()))
                {
                    currentNode = currentNode.getSnake();
                }
                if(!Objects.isNull(currentNode.getLadder()))
                {
                    currentNode = currentNode.getLadder();
                }
                System.out.println("Checked position = "+currentNode.getData().toString());
                if(Integer.parseInt(currentNode.getData().toString()) == 100)
                {
                    System.out.println("You've won");
                    System.exit(1);
                }
            }
        }
    }

    public void insertSnakesAndLadders(Map snakeMap, Map ladderMap)
    {
        Iterator snakeIterator = snakeMap.entrySet().iterator();
        while (snakeIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)snakeIterator.next();
            for(Node currentNode = start; !Objects.isNull(currentNode) ; currentNode = currentNode.getLink())
            {
                if(currentNode.getData().equals(pair.getKey()))
                {
                    Node setSnake = findResultNode(pair.getValue());
                    if(!Objects.isNull(setSnake))
                    {
                        currentNode.setSnake(setSnake);
                    }
                }
            }
            snakeIterator.remove();
        }

        Iterator ladderIterator = ladderMap.entrySet().iterator();
        while (ladderIterator.hasNext()) {
            Map.Entry pair = (Map.Entry)ladderIterator.next();
            for(Node currentNode = start; !Objects.isNull(currentNode) ; currentNode = currentNode.getLink())
            {
                if(currentNode.getData().equals(pair.getKey()))
                {
                    Node setLadder = findResultNode(pair.getValue());
                    if(!Objects.isNull(setLadder))
                    {
                        currentNode.setLadder(setLadder);
                    }
                }
            }
            ladderIterator.remove();
        }
    }

    private void insert(Object data)
    {
        Node temp = new Node();
        temp.setData(data);
        temp.setLink(null);
        temp.setLadder(null);
        temp.setSnake(null);
        if(Objects.isNull(start))
        {
            start = temp;
        }
        else
        {
            Node currentNode;
            for(currentNode = start ; !Objects.isNull(currentNode.getLink()) ; currentNode = currentNode.getLink());
            currentNode.setLink(temp);
        }
    }

    private Node findResultNode(Object resultValue)
    {
        for(Node currentNode = start; !Objects.isNull(currentNode) ; currentNode = currentNode.getLink())
        {
            if(currentNode.getData().equals(resultValue))
            {
                return currentNode;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        SnakeAndLadder game = new SnakeAndLadder();
        game.setUp();
        game.playGame();
    }
}

