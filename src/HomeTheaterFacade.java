public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    StreamingPlayer player;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;


    public HomeTheaterFacade(Amplifier amp, Tuner tuner, StreamingPlayer player, TheaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.player = player;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    // 기타 메서드

    public void watchMovie(String movie){
        System.out.println("영화 볼 준비 중");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projecteor.on();
        player.on();
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("홈시어터를 끄는 중");
        popper.off();
        lights.on();
        screen.up();
        player.stop();
        player.off();
    }
}
