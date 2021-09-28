import java.text.DecimalFormat;
import java.util.Locale;


class Acomodacao implements Cloneable {

    private String hostId;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;
    
    private Region region;
    private Room room;

    public Acomodacao(String roomId, String hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
            String propertyType) {
        
        this.setRoom(new Room(roomId, roomType));
        this.hostId = hostId;
        this.setRegion(new Region(country, city, neighbourhood));
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;

    }
    
    public Acomodacao(Room room, String hostId, Region region,
        int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
        String propertyType) {

        this.hostId = hostId;
        this.room = room;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.region = region;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;

    }
    
    // Setters
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }  
    
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    
    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }
    
    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }
    
    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }
   
    public void setRoom(Room room) {
        this.room = room;
    }
   
    // Getters 
    public Room getRoom() {
        return room;
    }

    public Region getRegion() {
        return region;
    }
        
    public String getHostId() {
        return this.hostId;
    }
    
    public int getReviews() {
        return this.reviews;
    }

    public double getOverallSatisfaction() {
        return this.overallSatisfaction;
    }

    public int getAccommodates() {
        return this.accommodates;
    }

    public double getBedrooms() {
        return this.bedrooms;
    }

    public double getPrice() {
        return this.price;
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    // Clone
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // ler
    public static void ler() {
        int n = MyIO.readInt();
        Acomodacao[] vetor = new Acomodacao[n];
        for (int i = 0; i < vetor.length; i++) {
            String s = MyIO.readLine();
            String[] entrada = s.split("\t");
            String roomId = entrada[0];
            String hostId = entrada[1];
            String roomType = entrada[2];
            Room room = new Room(roomId, roomType);
            Region region = new Region(entrada[3], entrada[4], entrada[5]);
            int reviews = Integer.parseInt(entrada[6]);
            double overallSatisfaction = Double.parseDouble(entrada[7]);
            int accommodates = Integer.parseInt(entrada[8]);
            double bedrooms = Double.parseDouble(entrada[9]);
            double price = Double.parseDouble(entrada[10]);
            String propertyType = entrada[11];

            vetor[i] = new Acomodacao(room, hostId, region,
            reviews,  overallSatisfaction, accommodates, bedrooms, price,
            propertyType);
        }

        String e;
        String id;
        while (true) {
            e = MyIO.readLine();
            if (e.equals("FIM")) {
                break;
            } else {
                id = e;
                for (int i = 0; i < vetor.length; i++) {
                    if (vetor[i].room.getId().equals(id)) {
                        vetor[i].imprimir();
                    }
                }
            }

        }
    }

    public String formataFlutuante(double v) {

        Locale.setDefault(new Locale("en", "US"));
        DecimalFormat df = new java.text.DecimalFormat("#0.0");

        String output = df.format(v);

        return output;
    }

    // imprimir
    public void imprimir() {
        String str;

        String priceFormatted = formataFlutuante(price);
        String bedroomsFormatted = formataFlutuante(bedrooms);
        String overallSatisfactionFormatted = formataFlutuante(overallSatisfaction);

        str = String.format("[%s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %d ## %s ## %s ## %s]", this.room.getId(),
                this.hostId, this.room.getType(), this.region.getCountry(), this.region.getCity(), this.region.getNeighbourhood(), this.reviews,
                overallSatisfactionFormatted, this.accommodates, bedroomsFormatted, priceFormatted, this.propertyType);

        MyIO.println(str);
    }

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");

        Acomodacao.ler();

    }
}