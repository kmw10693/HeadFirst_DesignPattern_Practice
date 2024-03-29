public abstract class Duck {
    FlyBehavior flyBehavior;
    QuickBehavior quickBehavior;

    public Duck() { }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quickBehavior.quack();
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuickBehavior(QuickBehavior qb) {
        quickBehavior = qb;
    }
}
