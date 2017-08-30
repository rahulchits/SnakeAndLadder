/**
 * Created by Admin on 30-08-2017.
 */
public class Node {

    private Object data;
    private Node link;
    private Node ladder;
    private Node snake;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Node getLadder() {
        return ladder;
    }

    public void setLadder(Node ladder) {
        this.ladder = ladder;
    }

    public Node getSnake() {
        return snake;
    }

    public void setSnake(Node snake) {
        this.snake = snake;
    }
}
