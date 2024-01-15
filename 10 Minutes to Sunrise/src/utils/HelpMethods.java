package utils;

import main.Game;

public class HelpMethods {

	public static boolean CanMoveHere(float x, float y, float width, float height) {
		if (!IsBorder(x, y)) {
			if (!IsBorder(x + width, y + height)) {
				return true;
			}
		}
		return false;
	}

	private static boolean IsBorder(float x, float y) {
		if (x < 0 || x >= Game.GAME_WIDTH)
			return true;
		if (y < 0 || y >= Game.GAME_HEIGHT)
			return true;
		return false;
	}
}
