package com.quchen.flappycow.sprites;

import com.quchen.flappycow.Game;
import com.quchen.flappycow.GameView;

public class CollidableSprites extends Sprite{

    public CollidableSprites(GameView view, Game game) {
        super(view, game);

    }

    public boolean isColliding(Sprite sprite){
        if(this.x + getCollisionTolerance() < sprite.x + sprite.width
                && this.x + this.width > sprite.x + getCollisionTolerance()
                && this.y + getCollisionTolerance() < sprite.y + sprite.height
                && this.y + this.height > sprite.y + getCollisionTolerance()){
            return true;
        }
        return false;
    }

    public boolean isCollidingRadius(Sprite sprite, float factor){
        int m1x = this.x+(this.width>>1);
        int m1y = this.y+(this.height>>1);
        int m2x = sprite.x+(sprite.width>>1);
        int m2y = sprite.y+(sprite.height>>1);
        int dx = m1x - m2x;
        int dy = m1y - m2y;
        int d = (int) Math.sqrt(dy*dy + dx*dx);

        if(d < (this.width + sprite.width) * factor
                || d < (this.height + sprite.height) * factor){
            return true;
        }else{
            return false;
        }
    }


    private int getCollisionTolerance(){
        // 25 @ 720x1280 px
        return game.getResources().getDisplayMetrics().heightPixels / 50;
    }

    public void onCollision(){
        // Every subclass has to specify this itself
    }

}
