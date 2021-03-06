import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by hegyi on 2017-04-10.
 */
public class Area extends GameObject{

  String[][] wallPositions = new String[10][10];
  int size;
  Path path;
  int areaLevel;


  public Area() {
    this.areaLevel = 1;
    readBoard("assets/wallposition.csv");
  }

  public void readBoard(String in) {
    this.path = Paths.get("assets/wallposition.csv");
    try {
      List<String> lines = Files.readAllLines(path);
      for (int i = 0; i < lines.size(); i++) {
        String[] line = lines.get(i).split(";");
        wallPositions[i] = line;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  boolean isWall(int x, int y) {
    if ((wallPositions[x][y]).equals("1")) {
        return true;
    } else {
      return false;
    }
  }

  void drawBoard(Graphics graphics) {
    size = 72;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (isWall(i, j)) {
          NotEmptyTile notEmptyTile = new NotEmptyTile(i * size,j * size);
          notEmptyTile.draw(graphics);
        } else {
          EmptyTile emptyTile = new EmptyTile(i * size,j * size);
          emptyTile.draw(graphics);
        }
      }
    }
  }

  public void drawHub(Graphics graphics,String info) {
    graphics.setColor(Color.BLACK);
    graphics.setColor(Color.GRAY);
    graphics.fillRect(0, 720, 720, 50);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(0,720,720,50);
    graphics.setColor(Color.BLACK);
    graphics.drawString(info, 10, 740);
  }

}
