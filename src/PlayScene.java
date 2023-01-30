/** PlayScene.java
 *  Extends SceneBuilder. Makes a scene that contains PlayNodes.java
 *
 *   @author Sina Akhavan
 */
public class PlayScene extends SceneBuilder{
    public PlayScene() {
        super(new PlayNodes().getRoot());
    }
}
