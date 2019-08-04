package chapter20;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constriants = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    @Override
    public String toString() {
        return super.toString();
    }
}
