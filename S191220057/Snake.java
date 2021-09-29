package S191220057;

public class Snake {

    private static Snake theSnake;

    public static Snake getTheSnake() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step, linables);//将妖怪们的信息（序号、当前位置）一起传过去执行交换
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    //得到对应序号的妖怪
    private Linable getMonsterByRank(Linable[] linables,int val)
    {
        for (Linable monster : linables) {
            if (monster.getValue()== val) {
                return monster;
            }
        }
        return null;
    }

    private void execute(String step,Linable[] linables) {
        String[] couple = step.split("<->");
        getMonsterByRank(linables,Integer.parseInt(couple[0]))
                .swapPosition(getMonsterByRank(linables,Integer.parseInt(couple[1])));
    }

}
