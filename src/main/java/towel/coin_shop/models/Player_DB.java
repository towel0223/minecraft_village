package towel.coin_shop.models;

public class Player_DB {

    private String uuid;
    private int money;
    private String displayName;
    private String nickName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Player_DB(String uuid, int money, String displayName, String nickName) {
        this.uuid = uuid;
        this.money = money;
        this.displayName = displayName;
        this.nickName = nickName;
    }

    public Player_DB() {
    }
}
