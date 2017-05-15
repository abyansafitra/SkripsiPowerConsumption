package imageloader.skripsi.abyansafitra.skripsipowerconsumption;


public class ModelFoto {

        private String user, foto_profil, foto, like, status, lokasi;

        public ModelFoto() {
        }

        public ModelFoto(String user, String foto_profil, String foto, String like, String status, String lokasi) {
            this.user = user;
            this.foto_profil = foto_profil;
            this.foto = foto;
            this.like= like;
            this.status = status;
            this.lokasi = lokasi;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String name) {
            this.user = name;
        }


        public String getFoto_profil() {
            return foto_profil;
        }

        public void setFoto_profil(String foto_profil) {
            this.foto_profil = foto_profil;
        }


        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }


        public String getStatus() {
        return status;
    }

        public void setStatus(String status) {
        this.status = status;
    }


        public String getLokasi() {
        return lokasi;
    }

        public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }


        public String getFoto() {
        return foto;
    }

        public void setFoto(String foto) {
        this.foto = foto;
    }

}
