package fifo

import org.scalatest.freespec.AnyFreeSpec
import os._

class VerilatorCovParseSpec extends AnyFreeSpec {
  private def parseLine(line: String): CoverageEntry = {
    println(line)
    if (!line.startsWith("C '\u0001")) assert(false)
    line.split('\'').toList match {
      case List(_, dict, countStr) =>
        println(dict, countStr)
        //println(dict.drop(1).split(j))
        println(dict.drop(1).split('\u0001').toSeq.map(_.split('\u0002').toList))
        val entries = dict.drop(1).split('\u0001').map(_.split('\u0002').toList).map { case Seq(k, v) => k -> v }.toMap
        println(entries)
        val count = countStr.trim.toLong
        //val path = entries("h").split('.').toList.drop(2).mkString(".")
        val kind = entries("page").split("/").head
        val cov = CoverageEntry(file = entries("f"), line = entries("l").toInt, path = entries("h"), count = count, kind = kind)
        // filter out non-user coverage
        /*
        kind match {
          case "v_user" => Some(cov)
          case _        => None
        }
         */
        cov
      case _ =>
        throw new RuntimeException(s"Unexpected coverage line format: $line")
    }
  }

  private case class CoverageEntry(file: String, line: Int, path: String, count: Long, kind: String)

  "parse" in {
    val covDat = os.read(os.pwd / "coverage.dat").split('\n').drop(1)
    val parsed = covDat.map(line => parseLine(line)).toSeq
    println(parsed)
  }

}
