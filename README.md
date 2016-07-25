git-info
===

[![Build Status](https://travis-ci.org/dgouyette/git-info.svg?branch=master)](https://travis-ci.org/dgouyette/git-info)

A small library (like https://github.com/sbt/sbt-buildinfo) to obtain git informations (hash, commit time, author,...) but at compile time.

This help to illustrate how macros work

Install as dependency
---
```scala
libraryDependencies ++= Seq(
  "org.cestpasdur" %% "git-info" % "1.0.0"
)
```

Usage
---


```scala
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
```
