package tb.soft;

public class Celebrity extends Person implements Comparable<Celebrity> {

    public Celebrity(String first_name, String last_name) throws PersonException {
        super(first_name, last_name);
    }

    @Override
    public int compareTo(Celebrity o) {
        return this.getBirthYear() - o.getBirthYear();
    }

    @Override
    public final boolean equals(Object o){
        if (o == this) return true;
        if (o instanceof Celebrity) {
            Celebrity other = (Celebrity) o;
            return getFirstName().equals(other.getFirstName()) &&
                    getLastName().equals(other.getLastName()) &&
                    getBirthYear() == other.getBirthYear() &&
                    getJob().equals(other.getJob());
        }
        return false;
    }

    @Override
    public final int hashCode(){
        return 17*getFirstName().hashCode() + 31 * getLastName().hashCode() +
                13 * getBirthYear() + 7 * getJob().hashCode();
    }
}
