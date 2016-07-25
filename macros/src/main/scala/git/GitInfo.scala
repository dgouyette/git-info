package git

import java.time.LocalDate
import java.util.Date

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.eclipse.jgit.storage.file.FileRepositoryBuilder

import scala.language.experimental.macros
import scala.reflect.macros.blackbox
import scala.collection.JavaConversions._

object GitInfo {


  /**  Internal **/

  private def loadGitRepository(c: blackbox.Context): Repository = {
    new FileRepositoryBuilder()
      .findGitDir(c.enclosingPosition.source.file.file)
      .setMustExist(true)
      .build()
  }

  private def lastRevCommitName(git: Git): String = git.log().call().toList match {
    case h :: _ => h.getName
    case Nil => "N/A"
  }

  private def lastRevCommitAuthorName(git: Git): String = git.log().call().toList match {
    case h :: _ => h.getAuthorIdent.toExternalString
    case Nil => "N/A"
  }

  private def lastRevCommitMessage(git: Git): String = git.log().call().toList match {
    case h :: _ => h.getFullMessage
    case Nil => "N/A"
  }

  private def lastRevCommitDate(git: Git): String = git.log().call().toList match {
    case h :: _ => new Date(h.getCommitTime.toLong * 1000L).toString
    case Nil => "N/A"
  }

  /**  macros **/

  def lastRevCommitName(): String = macro lastRevCommitName_impl
  def lastRevCommitName_impl(c: blackbox.Context)(): c.Expr[String] = {
    val git = Git.wrap(loadGitRepository(c))
    import c.universe._
    c.Expr[String](q""" ${lastRevCommitName(git)} """)
  }

  def lastRevCommitAuthor(): String = macro lastRevCommitAuthor_impl
  def lastRevCommitAuthor_impl(c: blackbox.Context)(): c.Expr[String] = {
    val git = Git.wrap(loadGitRepository(c))
    import c.universe._
    c.Expr[String](q""" ${lastRevCommitAuthorName(git)} """)
  }


  def currentBranch(): String = macro currentBranch_impl
  def currentBranch_impl(c: blackbox.Context)(): c.Expr[String] = {
    import c.universe._
    c.Expr[String](q""" ${loadGitRepository(c).getBranch}""")
  }

  def lastRevCommitMessage(): String = macro lastRevCommitMessage_impl
  def lastRevCommitMessage_impl(c: blackbox.Context)(): c.Expr[String] = {
    import c.universe._
    val git = Git.wrap(loadGitRepository(c))
    c.Expr[String](q""" ${lastRevCommitMessage(git)} """)
  }

  def lastRevCommitTime(): String = macro lastRevCommitTime_impl
  def lastRevCommitTime_impl(c: blackbox.Context)(): c.Expr[String] = {
    import c.universe._
    val git = Git.wrap(loadGitRepository(c))
    c.Expr[String](q""" ${lastRevCommitDate(git)} """)
  }


}
