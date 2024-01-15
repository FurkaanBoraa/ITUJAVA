package components;

public class Key {
	private boolean right, left, space, key_j, key_k, key_enter;

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isKey_enter() {
		return key_enter;
	}

	public void setKey_enter(boolean key_enter) {
		this.key_enter = key_enter;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isSpace() {
		return space;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}

	public boolean isKey_j() {
		return key_j;
	}

	public void setKey_j(boolean key_j) {
		this.key_j = key_j;
	}

	public boolean isKey_k() {
		return key_k;
	}

	public void setKey_k(boolean key_k) {
		this.key_k = key_k;
	}
}
