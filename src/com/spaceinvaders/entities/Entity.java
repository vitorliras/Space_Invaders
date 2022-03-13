package com.spaceinvaders.entities;

import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.spaceinvaders.main.Game;
import com.spaceinvaders.world.Camera;
import com.spaceinvaders.world.Node;
import com.spaceinvaders.world.World;




public class Entity {
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double speed;
	
	public int depth;
	
	protected List<Node> path;
	
	public  boolean debug = false;
	
	protected BufferedImage sprite;
	
	public static Random rand = new Random();
	
	public Entity( double y, double x, int width, int height, double speed, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.sprite = sprite;
	}
	
	public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity n0, Entity n1) {
			if(n1.depth < n0.depth) {
				return + 1;
			}if(n1.depth > n0.depth) {
				return -1;	
			}
			
			return 0;
			
		}
	};
	
	public void updateCamera() {
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2),0,World.WIDTH*16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2),0,World.HEIGHT*16 - Game.HEIGHT);
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
}
