package S191220057;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Scene {

    public static void main(String[] args) throws IOException {
    final int mycount = 64;

    Line line = new Line(mycount);
    Random r = new Random(1);
    for(int j = 1;j <= mycount;++j)
    {
        
        //生成rbg的随机数
        int ran1 = r.nextInt(6)*51;
        int ran2 = r.nextInt(6)*51;
        int ran3 = r.nextInt(6)*51;
        
        //生成新妖怪
        Monster monster = new Monster();
        monster.setMonster(ran1, ran2, ran3, j);
       
        //随机初始位置
        int pos = r.nextInt(mycount);
        line.put(monster, pos);
    }
    

    Snake theSnake = Snake.getTheSnake();

    Sorter sorter1 = new BubbleSorter();
    Sorter sorter2 = new QuickSorter();

    theSnake.setSorter(sorter2);

    String log = theSnake.lineUp(line);

    BufferedWriter writer;
    writer = new BufferedWriter(new FileWriter("result.txt"));
    writer.write(log);
    writer.flush();
    writer.close();
    }
}
