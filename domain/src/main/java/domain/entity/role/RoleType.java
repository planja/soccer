package domain.entity.role;

/**
 * Created by admin on 08.11.2016.
 */
public enum RoleType {
    ROLE_ADMIN(0, "ADMIN"),
    ROLE_BLOGGER(1, "BLOGGER"),
    ROLE_MODERATOR(2, "MODERATOR"),
    ROLE_USER(3, "USER");

    private final int value;
    private final String text;

    RoleType(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
