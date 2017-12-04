git-info
===

[![Build Status](https://travis-ci.org/dgouyette/git-info.svg?branch=master)](https://travis-ci.org/dgouyette/git-info)

A small library (like https://github.com/sbt/sbt-buildinfo) to obtain git informations (hash, commit time, author,...) but at compile time.

This help to illustrate how macros work

Install as dependency
---

build.sbt : 

```scala
resolvers += Resolver.bintrayRepo("dgouyette", "maven")

libraryDependencies ++= Seq(
  "org.cestpasdur" %% "git-info" % "0.2.1",
)
```

Usage (in a playframework webapp)
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

That will display : 


```json
{
  "lastCommit": {
    "branch": "master",
    "message": "add git-info to display last commit info",
    "author": "Damien GOUYETTE <damien.gouyette@gmail.com> 1469442718 +0200",
    "hash": "6024dcc98bd563b0ab78c7a663c52ebadbbaf456",
    "date": "Mon Jul 25 12:32:15 CEST 2016"
  }
}
```
