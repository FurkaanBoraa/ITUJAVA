package utils;

import main.Game;

public class Constants {

	public static class EnemyConstants{
		public static final int ENEMY_WIDTH_DEFAULT = 24;
		public static final int ENEMY_HEIGHT_DEFAULT = 28;
		public static final int ENEMY_WIDTH = (int)(ENEMY_WIDTH_DEFAULT * Game.SCALE);
		public static final int ENEMY_HEIGHT = (int)(ENEMY_HEIGHT_DEFAULT * Game.SCALE);
	}
	public static class UI{
		public static class Buttons{
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT * Game.SCALE);
	
		}
	}
	
	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int SHOOTING_RUNNING = 2;
		public static final int GUN = 5;
		public static int GetSpriteAmount(int playerAction) {
			switch (playerAction) {
			case IDLE: {
				return 6;
			}
			case RUNNING: {
				return 4;
			}
			case SHOOTING_RUNNING: {
				return 8;
			}
			case GUN:
				return 5;
			default:
				throw new IllegalArgumentException("Unexpected value: " + playerAction);
			}
		}

	}
}
