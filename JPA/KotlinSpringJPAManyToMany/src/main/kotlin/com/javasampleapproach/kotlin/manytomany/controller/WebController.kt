package com.javasampleapproach.kotlin.manytomany.controller

import com.javasampleapproach.kotlin.manytomany.model.Token
import com.javasampleapproach.kotlin.manytomany.model.NodeInfoContainer
import com.javasampleapproach.kotlin.manytomany.repo.TokenRepository
import com.javasampleapproach.kotlin.manytomany.repo.NodeInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.transaction.Transactional
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@RestController
@RequestMapping("/")
class WebController {


    @Autowired
    lateinit var tokenRepository: TokenRepository


    @Autowired
    lateinit var nodeInfoRepo: NodeInfoRepository

    @GetMapping("/clear")
    @Transactional
    fun clear(): String {
        // delete all data
        tokenRepository.deleteAll()
        nodeInfoRepo.deleteAll()

        return "Done!"
    }

    @GetMapping("/save")
    fun save(): String {
        var nodeContainer1 = NodeInfoContainer();
        var uuid = UUID.randomUUID();

        nodeContainer1.nodeInfoId = uuid.toString();
        // nodeContainer1.token = uuid.toString();

        nodeInfoRepo.save(nodeContainer1);

        return nodeContainer1.nodeInfoId;
    }

    @GetMapping("/save-inner")
    fun saveInner(): String {
        //  var nodeContainer1 = NodeInfoContainer();
        var uuid = UUID.randomUUID();


        val aa = Token()
        aa.token = "AA";

        val aaa = Token()
        aaa.token = "AAA";

        val aaaa = Token()
        aaaa.token = "AAAA";

        val conn = NodeInfoContainer()
        uuid = UUID.randomUUID();
        conn.nodeInfoId = uuid.toString()

        conn.tokens = listOf(aa, aaa, aaaa)

        nodeInfoRepo.save(conn)

        return conn.nodeInfoId;
    }

    @ResponseBody
    @RequestMapping(value = "/find-by-token", method = arrayOf(RequestMethod.GET))
    fun findByFullNameLike(token: String): String {
        val tokensList = nodeInfoRepo.findFirstByNodeInfoId(token)

        val sb = StringBuilder()

        if (tokensList!= null && tokensList.tokens.isNotEmpty()) {
            tokensList.tokens.forEach {
                sb.append(it.token + "<br>")
            }
        }

        return sb.toString()
    }
}