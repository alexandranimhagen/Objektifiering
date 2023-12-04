// En klass som representerar data från filen, med fält för varje kolumn i filen.
public class DataObject {
        // Fält för varje kolumn i filen
        private String A, B, C, D, E, F, G, H;

        // Konstruktor för att skapa ett DataObject med specifika värden för varje fält
        public DataObject(String A, String B, String C, String D, String E, String F, String G, String H) {
                this.A = A;
                this.B = B;
                this.C = C;
                this.D = D;
                this.E = E;
                this.F = F;
                this.G = G;
                this.H = H;
        }

        // Tom konstruktor för att skapa ett DataObject utan initiala värden
        public DataObject() {

        }

        // Get-metoder för att hämta värden från varje fält
        public String getA() {
                return A;
        }

        public void setA(String A) {
                this.A = A;
        }

        public String getB() {
                return B;
        }

        public void setB(String B) {
                this.B = B;
        }

        public String getC() {
                return C;
        }

        public void setC(String C) {
                this.C = C;
        }

        public String getD() {
                return D;
        }

        public void setD(String D) {
                this.D = D;
        }

        public String getE() {
                return E;
        }

        public void setE(String E) {
                this.E = E;
        }

        public String getF() {
                return F;
        }

        public void setF(String F) {
                this.F = F;
        }

        public String getG() {
                return G;
        }

        public void setG(String G) {
                this.G = G;
        }

        public String getH() {
                return H;
        }

        public void setH(String H) {
                this.H = H;
        }
}
