import java.text.DecimalFormat;

class Acomodacao implements Cloneable {
    private String roomId;
    private String hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;
    private String descricao;

    
    public Acomodacao(String roomId, String hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
            String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
        this.descricao="";
    }


    
    public Acomodacao(String roomId,String hostId, String roomType, String country, String city, String neighbourhood,
            int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
            String propertyType, String descricao) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
        this.descricao = descricao;
    }
    
    //Setters
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }
    public void setHostId(String hostId){
        this.hostId = hostId;
    }
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setNeighbourhood(String neighbourhood){
        this.neighbourhood = neighbourhood;
    }
    public void setReviews(int reviews){
        this.reviews = reviews;
    }
    public void setOverallSatisfaction(double overallSatisfaction){
        this.overallSatisfaction = overallSatisfaction;
    }
    public void setAccommodates(int accommodates){
        this.accommodates = accommodates;
    }
    public void setBedrooms(double bedrooms){
        this.bedrooms = bedrooms; 
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setPropertyType(String propertyType){
        this.propertyType = propertyType;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    //Getters       
    public String getRoomId(){
        return this.roomId;
    }
    public String getHostId(){
        return this.hostId;
    }
    public String getRoomType(){
        return this.roomType;
    }
    public String getCountry(){
        return this.country;
    }
    public String getCity(){
        return this.city; 
    }
    public String getNeighbourhood(){
        return this.neighbourhood;
    }
    public int getReviews(){
        return this.reviews;
    }
    public double getOverallSatisfaction(){
        return this.overallSatisfaction;
    }
    public int getAccommodates(){
        return this.accommodates;
    }
    public double getBedrooms(){
        return this.bedrooms;
    }
    public double getPrice(){
        return this.price;
    }
    public String getPropertyType(){
        return this.propertyType;
    }
    public String getDescricao(){
        return this.descricao;
    }

    //Clone
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    // ler
    public static void ler(){
        int n = MyIO.readInt();
        Acomodacao[] vetor = new Acomodacao[n];
        for (int i = 0; i < vetor.length; i++) {
            String s = MyIO.readLine();
            String[] entrada = s.split("	");
            String roomId = entrada[0];
            String hostId = entrada[1];
            String roomType = entrada[2];
            String country = entrada[3];
            String city= entrada[4]; 
            String neighbourhood= entrada[5];
            int reviews= Integer.parseInt(entrada[6]);
            double overallSatisfaction = Double.parseDouble(entrada[7]);
            int accommodates= Integer.parseInt(entrada[8]);
            double bedrooms = Double.parseDouble(entrada[9]); 
            double price= Double.parseDouble(entrada[10]);
            String propertyType = entrada[11];
            vetor[i] = new Acomodacao(roomId,hostId,roomType,country,city,neighbourhood,reviews,overallSatisfaction,accommodates, bedrooms, price,propertyType); 
        }

        String e; 
        String id;
        while (true) {
            e = MyIO.readLine();
            if (e.equals("FIM")) {
                break;
            }else{
                id = e;
                for (int i=0; i< vetor.length; i++) {
                    if (vetor[i].getRoomId().equals(id)) {
                        vetor[i].imprimir();
                    }
                }
            }

        }
    }

    public String formataFlutuante(double v) {

        return dec.forma; 
    }

    // imprimir
    public void imprimir(){
        String str;

        String priceFormatted = formataFlutuante(price);
        String bedroomsFormatted = formataFlutuante(bedrooms);
        String overallSatisfactionFormatted = formataFlutuante(overallSatisfaction);

        str = String.format("[%s ## %s ## %s ## %s ## %s ## %s ## %d ## %.1f ## %d ## %.1f ## %.1f ## %s]",this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighbourhood, this.reviews, overallSatisfactionFormatted, this.accommodates, bedroomsFormatted, priceFormatted, this.propertyType);

        MyIO.println(str); 
    }

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");

        Acomodacao.ler();

    }
}