package net.colinjohnson.game;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Entity {
	private UUID id;
	private boolean isMovable = true; 
	private float x = 0; // X-Position
	private float y = 0; // Y-Position
	private float v = 1; // velocity
	private float vMax = 10; // maximum allowed velocity
	private float size = 10;
	private String name = ""; // Entity name	
	private float rotation = 0;
	private Sprite sprite;
	private Body body;
	
	public Entity (float x, float y, String name){
		sprite = new Sprite(new Texture("Missing.png"));
		this.x = x;
		this.y = y;
		this.name = name; 
		setId(UUID.randomUUID());
	} // Entity Constructor;
	
	
	public void update(){
		x = body.getPosition().x;
		y = body.getPosition().y;
	}
	
	abstract void defineBody();

	public float getX() {
		return x;
	} // getX

	public void setX(float x) {
		this.x = x;
	} // setX

	public float getY() {
		return y;
	} // getY

	public void setY(float y) {
		this.y = y;
	} // setY

	public String getName() {
		return name;
	} // getName

	public void setName(String name) {
		this.name = name;
	} // setName

	public UUID getId() {
		return id;
	} // getId

	public void setId(UUID id) {
		this.id = id;
	} // setId

	public boolean isMovable() {
		return isMovable;
	}

	public void setMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}

	public float getvMax() {
		return vMax;
	}

	public void setvMax(float vMax) {
		this.vMax = vMax;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
		sprite.setRotation(rotation);
		getBody().setTransform(getBody().getWorldCenter(), (float) Math.toRadians(getRotation()));
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public float getV() {
		return v;
	}

	public void setV(float v) {
		this.v = v;
	}
} // Entity
