package controllers
import javax.inject.Inject

import git.GitInfo
import play.api.libs.json.Json
import play.api.mvc._

class VersionController @Inject()(cc: ControllerComponents)  extends AbstractController(cc) {

  def index = Action {
    Ok(
      Json.obj(
        "lastCommit" -> Json.obj(
          "branch" -> GitInfo.currentBranch(),
          "message" -> GitInfo.lastRevCommitMessage(),
          "author" -> GitInfo.lastRevCommitAuthor(),
          "hash" -> GitInfo.lastRevCommitName(),
          "date" -> GitInfo.lastRevCommitTime()
        ))
    )
  }

}
