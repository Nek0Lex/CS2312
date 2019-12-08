package Lab5.Q6;

public class AgeGroupCounter extends Counter {
    private int ageStart, ageEnd;

    public AgeGroupCounter(int AgeStart, int AgeEnd){
        this.ageStart = AgeStart;
        this.ageEnd = AgeEnd;
    }

    public void countData(Record r) {
        if (r.getAge()>=ageStart && r.getAge()<=ageEnd)
            super.countData(r);
    }

    public String toString()
    {
        return String.format("[Age %d to %d] Count = %d", ageStart, ageEnd, getCount());
    }
}
