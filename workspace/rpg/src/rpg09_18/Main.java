package rpg09_18;

public class Main {

	public static void main(String[] args) {
//		Sword s = new Sword();
//		h.sword.name = "炎の件";
//		s.damage = 10;
		Hero h = new Hero();
		h.name = "ミナト";
		h.hp = 100;
		h.sword = new Sword();
//		h.sword.name = "炎の件";
//		h.sword.damage = 10;
//		System.out.println("現在の武器は" + h.sword.name);
		Hero sh = new SuperHero();
		sh.name = "えもち";
		SuperHero ssh = (SuperHero) sh;

		ssh.skill();


		Wizard w = new Wizard();
		w.name = "谷川";
		w.heal(ssh);

	}

}
