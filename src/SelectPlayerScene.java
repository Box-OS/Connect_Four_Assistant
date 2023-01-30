/** SelectPlayerScene.java
 *  Extends SceneBuilder. Makes a scene that contains SelectPlayerNodes.java
 *
 *   @author Sina Akhavan
 */
public class SelectPlayerScene extends SceneBuilder {
    public SelectPlayerScene(StageBuilder stage) {
        super(new SelectPlayerNodes(stage).getRoot());
    }
}
