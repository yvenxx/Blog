package cn.yvenxx.system.controller;

import cn.yvenxx.common.entity.TArticle;
import cn.yvenxx.system.service.ITArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/article")
public class TArticleController {

    @Autowired
    private ITArticleService articleService;

    @GetMapping
    public ResponseEntity<List<TArticle>> getAllArticles() {
        return ResponseEntity.ok(articleService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TArticle> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TArticle> createArticle(@RequestBody TArticle article) {
        return ResponseEntity.ok(articleService.save(article) ? article : null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TArticle> updateArticle(@PathVariable Long id, @RequestBody TArticle article) {
        article.setId(id);
        return ResponseEntity.ok(articleService.updateById(article) ? article : null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.removeById(id);
        return ResponseEntity.ok().build();
    }
}