```mermaid 
classDiagram
direction BT
class Beispiel {
<<enumeration>>
  + int bspInt
  + String bspString
  + boolean bspBool
  + values() Beispiel[]
  + valueOf(String) Beispiel
  + String bspString
  + int bspInt
  + boolean bspBool
}
class Enemy {
  + int hp
  + int id
  + Icon skin
  + int y
  + int width
  + int height
  + int x
  + int speed
  + EnemyE typ
  + hpHit(int) void
  + EnemyE typ
  + int width
  + int hp
  + Icon skin
  + int x
  + int y
  + int id
  + int ID
  + int height
  + int speed
}
class EnemyE {
<<enumeration>>
  + int height
  + Icon skin
  + MobMoveE move
  + int speed
  + int hp
  + int width
  + getSize(EnemyE, Level) int
  + valueOf(String) EnemyE
  + getHeight(EnemyE) int
  + getMove(EnemyE) MobMoveE
  + getWidth(EnemyE) int
  + getSkin(EnemyE) Icon
  + values() EnemyE[]
  + getHp(EnemyE) int
  + getSpeed(EnemyE) int
  + int height
  + int hp
  + int width
  + MobMoveE move
  + Icon skin
  + int speed
}
class EnemyHandler {
  + remove() void
  + startEnemy() void
  + move() void
  + EnemyInit(Level) void
  + int anzahlE
}
class HelloApplication {
  + main(String[]) void
  + start(Stage) void
}
class HelloController {
  + onHelloButtonClick() void
}
class Keyboard {
  + keyReleased(KeyEvent) void
  + keyPressed(KeyEvent) void
  + keyTyped(KeyEvent) void
}
class Level {
  + generateLevel() int[]
  + int numberAffe
  + int numberKitty
  + int numberDwarf
  + int numberPuffy
  + int numberUnicorns
}
class Main {
  + sleep(long) void
  + start() void
  + startSpiel() void
  + main(String[]) void
  + stopSpiel() void
  + Screen screen
}
class MobMoveE {
<<enumeration>>
  + setAbstand2() void
  + bew(MobMoveE, int, double, double, int) double
  + setAbstand1() void
  + valueOf(String) MobMoveE
  + bool() void
  + values() MobMoveE[]
}
class Move {
  + main(String[]) void
  + collision() void
  + PvE(JLabel, JLabel) boolean
  + PvB(JLabel, JLabel) boolean
  + keyPressed(KeyEvent) void
  + sleep(long) void
  + shot() void
  + enemyMove(int) void
  + keyTyped(KeyEvent) void
  + keyReleased(KeyEvent) void
}
class Player {
  + int speed
  + int width
  + int speed
  + int width
}
class Screen {
  + shot() void
  + w() void
  + move(int, EnemyE, int) void
  + levelEnd() void
  + enemyShot(int, int) void
  + rectCollision(JLabel, JLabel) boolean
  + updateLevel() void
  + rainbow(int) int
  + updateLives() void
  + addEnemy(Enemy) int
  + d() void
  + setPause() void
  + s() void
  + rangeIntersect(int, int, int, int) boolean
  + space() void
  + start() void
  + a() void
  + spaceCat(int, int) void
  + updateScore() void
}
class Test {
  + enumo1v1() void
  + bild() void
  + sleep2(long) Exception?
  + main(String[]) void
  + bla() void
}
class ThreadBsp {
  + v2() void
  + v1(int) void
  + v3() void
  + main(String[]) void
  + sleep2(long) Exception?
}

Enemy "1" *--> "typ 1" EnemyE 
EnemyE "1" *--> "move 1" MobMoveE 
EnemyHandler "1" *--> "enemies *" Enemy 
EnemyHandler  ..>  Enemy : «create»
EnemyHandler  ..>  Level : «create»
EnemyHandler "1" *--> "levelE 1" Level 
EnemyHandler "1" *--> "s 1" Screen 
Main "1" *--> "enemyHandler 1" EnemyHandler 
Main  ..>  EnemyHandler : «create»
Main  ..>  Player : «create»
Main "1" *--> "player 1" Player 
Main  ..>  Screen : «create»
Main "1" *--> "s 1" Screen 
Move  ..>  Enemy : «create»
Screen  ..>  Keyboard : «create»
```