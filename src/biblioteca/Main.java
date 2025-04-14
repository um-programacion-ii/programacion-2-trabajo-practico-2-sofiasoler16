package biblioteca;

public class Main {
    public static void main(String[] args) {
        Podcast podcast = new Podcast("Vida de millonarios", 1, "LaCruda");

        System.out.println("Título: " + podcast.getTitulo());
        System.out.println("Canal: " + podcast.getCanal());
    }
}
