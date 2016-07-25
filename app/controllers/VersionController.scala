package controllers
import git.GitInfo
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

class VersionController extends Controller {


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
