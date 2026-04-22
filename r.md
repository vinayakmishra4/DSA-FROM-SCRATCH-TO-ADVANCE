<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>DSA From Scratch to Advance</title>
<link href="https://fonts.googleapis.com/css2?family=Space+Mono:wght@400;700&family=Syne:wght@400;600;700;800&family=DM+Sans:ital,wght@0,300;0,400;0,500;1,300&display=swap" rel="stylesheet"/>
<style>
  :root {
    --bg: #0a0a0f;
    --bg2: #0f0f1a;
    --bg3: #13131f;
    --border: rgba(255,255,255,0.07);
    --accent1: #7c6af7;
    --accent2: #f76a8a;
    --accent3: #6af7c8;
    --accent4: #f7c96a;
    --text: #e8e8f0;
    --muted: #888899;
    --card: rgba(255,255,255,0.03);
  }

  *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

  html { scroll-behavior: smooth; }

  body {
    background: var(--bg);
    color: var(--text);
    font-family: 'DM Sans', sans-serif;
    font-size: 15px;
    line-height: 1.7;
    overflow-x: hidden;
  }

  /* Noise overlay */
  body::before {
    content: '';
    position: fixed;
    inset: 0;
    background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 256 256' xmlns='http://www.w3.org/2000/svg'%3E%3Cfilter id='noise'%3E%3CfeTurbulence type='fractalNoise' baseFrequency='0.9' numOctaves='4' stitchTiles='stitch'/%3E%3C/filter%3E%3Crect width='100%25' height='100%25' filter='url(%23noise)' opacity='0.04'/%3E%3C/svg%3E");
    pointer-events: none;
    z-index: 1000;
    opacity: 0.5;
  }

  /* Animated background blobs */
  .bg-blobs {
    position: fixed;
    inset: 0;
    overflow: hidden;
    pointer-events: none;
    z-index: 0;
  }
  .blob {
    position: absolute;
    border-radius: 50%;
    filter: blur(80px);
    opacity: 0.12;
    animation: drift 20s infinite ease-in-out;
  }
  .blob1 { width: 600px; height: 600px; background: var(--accent1); top: -200px; left: -100px; animation-delay: 0s; }
  .blob2 { width: 400px; height: 400px; background: var(--accent2); top: 40%; right: -100px; animation-delay: -7s; }
  .blob3 { width: 500px; height: 500px; background: var(--accent3); bottom: -150px; left: 30%; animation-delay: -14s; }

  @keyframes drift {
    0%, 100% { transform: translate(0, 0) scale(1); }
    33% { transform: translate(30px, -40px) scale(1.05); }
    66% { transform: translate(-20px, 20px) scale(0.95); }
  }

  /* Layout */
  .container {
    position: relative;
    z-index: 1;
    max-width: 1100px;
    margin: 0 auto;
    padding: 0 24px;
  }

  /* ── HERO ── */
  .hero {
    padding: 100px 0 80px;
    text-align: center;
    position: relative;
  }

  .hero-eyebrow {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    font-family: 'Space Mono', monospace;
    font-size: 11px;
    letter-spacing: 3px;
    text-transform: uppercase;
    color: var(--accent3);
    border: 1px solid rgba(106,247,200,0.25);
    padding: 6px 16px;
    border-radius: 100px;
    margin-bottom: 32px;
    animation: fadeUp 0.6s ease both;
  }
  .hero-eyebrow::before { content: '▶'; font-size: 8px; }

  .hero-title {
    font-family: 'Syne', sans-serif;
    font-weight: 800;
    font-size: clamp(42px, 7vw, 80px);
    line-height: 1.0;
    letter-spacing: -2px;
    margin-bottom: 16px;
    animation: fadeUp 0.6s 0.1s ease both;
  }
  .hero-title span {
    background: linear-gradient(135deg, var(--accent1), var(--accent2));
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  .hero-sub {
    font-size: 18px;
    color: var(--muted);
    max-width: 500px;
    margin: 0 auto 48px;
    font-weight: 300;
    animation: fadeUp 0.6s 0.2s ease both;
  }

  .hero-badges {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    justify-content: center;
    margin-bottom: 56px;
    animation: fadeUp 0.6s 0.3s ease both;
  }

  .badge {
    font-family: 'Space Mono', monospace;
    font-size: 11px;
    padding: 5px 14px;
    border-radius: 6px;
    border: 1px solid;
  }
  .badge-python { color: #6af7c8; border-color: rgba(106,247,200,0.3); background: rgba(106,247,200,0.05); }
  .badge-stars  { color: #f7c96a; border-color: rgba(247,201,106,0.3); background: rgba(247,201,106,0.05); }
  .badge-forks  { color: #f76a8a; border-color: rgba(247,106,138,0.3); background: rgba(247,106,138,0.05); }

  .hero-stats {
    display: flex;
    justify-content: center;
    gap: 48px;
    animation: fadeUp 0.6s 0.4s ease both;
  }
  .stat {
    text-align: center;
  }
  .stat-num {
    font-family: 'Syne', sans-serif;
    font-size: 32px;
    font-weight: 800;
    color: var(--text);
  }
  .stat-label {
    font-size: 12px;
    color: var(--muted);
    font-family: 'Space Mono', monospace;
    letter-spacing: 1px;
  }

  /* ── DIVIDER ── */
  .divider {
    height: 1px;
    background: linear-gradient(90deg, transparent, var(--border), transparent);
    margin: 0 0 64px;
  }

  /* ── SECTION HEADING ── */
  .section-tag {
    font-family: 'Space Mono', monospace;
    font-size: 10px;
    letter-spacing: 3px;
    text-transform: uppercase;
    color: var(--accent1);
    margin-bottom: 12px;
  }
  .section-title {
    font-family: 'Syne', sans-serif;
    font-size: clamp(26px, 4vw, 36px);
    font-weight: 800;
    letter-spacing: -1px;
    margin-bottom: 40px;
  }
  .section-title em {
    font-style: normal;
    background: linear-gradient(135deg, var(--accent1), var(--accent2));
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  /* ── FEATURES ── */
  .features {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 16px;
    margin-bottom: 80px;
    animation: fadeUp 0.6s 0.5s ease both;
  }
  .feature-card {
    background: var(--card);
    border: 1px solid var(--border);
    border-radius: 16px;
    padding: 28px 24px;
    transition: border-color 0.3s, transform 0.3s;
  }
  .feature-card:hover {
    border-color: rgba(124,106,247,0.4);
    transform: translateY(-3px);
  }
  .feature-icon {
    font-size: 24px;
    margin-bottom: 12px;
  }
  .feature-title {
    font-family: 'Syne', sans-serif;
    font-weight: 700;
    font-size: 14px;
    margin-bottom: 6px;
    color: var(--text);
  }
  .feature-desc {
    font-size: 13px;
    color: var(--muted);
    line-height: 1.6;
  }

  /* ── PHASE BLOCK ── */
  .phase {
    margin-bottom: 64px;
  }
  .phase-header {
    display: flex;
    align-items: center;
    gap: 16px;
    margin-bottom: 24px;
  }
  .phase-number {
    font-family: 'Space Mono', monospace;
    font-size: 11px;
    color: var(--bg);
    background: var(--accent1);
    padding: 4px 10px;
    border-radius: 6px;
    font-weight: 700;
    letter-spacing: 1px;
    white-space: nowrap;
  }
  .phase-number.p2 { background: var(--accent2); }
  .phase-number.p3 { background: var(--accent3); color: #0a0a0f; }
  .phase-number.p4 { background: var(--accent4); color: #0a0a0f; }
  .phase-number.p5 { background: linear-gradient(135deg, var(--accent1), var(--accent2)); }
  .phase-number.p6 { background: linear-gradient(135deg, var(--accent3), var(--accent4)); color: #0a0a0f; }
  .phase-number.p7 { background: linear-gradient(135deg, var(--accent2), var(--accent4)); color: #0a0a0f; }

  .phase-title {
    font-family: 'Syne', sans-serif;
    font-size: 20px;
    font-weight: 700;
  }

  /* ── TABLE ── */
  .table-wrap {
    overflow-x: auto;
    border-radius: 14px;
    border: 1px solid var(--border);
  }
  table {
    width: 100%;
    border-collapse: collapse;
    font-size: 13.5px;
  }
  thead tr {
    background: rgba(255,255,255,0.04);
    border-bottom: 1px solid var(--border);
  }
  th {
    font-family: 'Space Mono', monospace;
    font-size: 10px;
    letter-spacing: 2px;
    text-transform: uppercase;
    color: var(--muted);
    padding: 14px 18px;
    text-align: left;
    font-weight: 400;
  }
  td {
    padding: 13px 18px;
    border-bottom: 1px solid var(--border);
    vertical-align: middle;
  }
  tr:last-child td { border-bottom: none; }
  tbody tr {
    transition: background 0.2s;
  }
  tbody tr:hover {
    background: rgba(124,106,247,0.05);
  }

  .star-icon { color: var(--accent4); margin-right: 4px; }
  .search-icon { color: var(--accent3); margin-right: 4px; }
  .rotate-icon { color: var(--accent2); margin-right: 4px; }

  .complexity {
    font-family: 'Space Mono', monospace;
    font-size: 11px;
    color: var(--muted);
  }
  .complexity .best { color: var(--accent3); }
  .complexity .worst { color: var(--accent2); }

  .link-btn {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    font-family: 'Space Mono', monospace;
    font-size: 10px;
    letter-spacing: 1px;
    padding: 5px 12px;
    border-radius: 8px;
    border: 1px solid var(--border);
    color: var(--accent1);
    text-decoration: none;
    background: rgba(124,106,247,0.07);
    transition: all 0.2s;
  }
  .link-btn:hover {
    background: rgba(124,106,247,0.18);
    border-color: rgba(124,106,247,0.5);
    transform: translateX(2px);
  }
  .link-btn::after { content: '→'; }

  /* ── TOC ── */
  .toc {
    background: var(--card);
    border: 1px solid var(--border);
    border-radius: 16px;
    padding: 32px;
    margin-bottom: 64px;
  }
  .toc-title {
    font-family: 'Syne', sans-serif;
    font-size: 16px;
    font-weight: 700;
    margin-bottom: 20px;
    color: var(--muted);
    letter-spacing: 1px;
    text-transform: uppercase;
    font-size: 11px;
    font-family: 'Space Mono', monospace;
  }
  .toc-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 8px;
  }
  .toc-item {
    display: flex;
    align-items: center;
    gap: 8px;
    padding: 9px 14px;
    border-radius: 8px;
    border: 1px solid transparent;
    color: var(--muted);
    font-size: 13px;
    cursor: pointer;
    transition: all 0.2s;
    text-decoration: none;
  }
  .toc-item:hover {
    border-color: var(--border);
    color: var(--text);
    background: rgba(255,255,255,0.03);
  }
  .toc-item span { font-size: 14px; }

  /* ── FOOTER ── */
  .footer {
    border-top: 1px solid var(--border);
    padding: 48px 0;
    margin-top: 40px;
    text-align: center;
  }
  .footer-made {
    font-size: 13px;
    color: var(--muted);
    margin-bottom: 16px;
  }
  .footer-made a {
    color: var(--accent1);
    text-decoration: none;
  }
  .footer-made a:hover { text-decoration: underline; }
  .footer-actions {
    display: flex;
    gap: 12px;
    justify-content: center;
    flex-wrap: wrap;
  }
  .footer-btn {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    padding: 10px 22px;
    border-radius: 100px;
    font-size: 13px;
    font-weight: 500;
    text-decoration: none;
    transition: all 0.2s;
    cursor: pointer;
  }
  .footer-btn.primary {
    background: var(--accent1);
    color: white;
  }
  .footer-btn.primary:hover { opacity: 0.85; transform: translateY(-2px); }
  .footer-btn.secondary {
    border: 1px solid var(--border);
    color: var(--muted);
  }
  .footer-btn.secondary:hover { border-color: rgba(255,255,255,0.2); color: var(--text); }

  /* ── PREREQS ── */
  .prereqs {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 14px;
    margin-bottom: 64px;
  }
  .prereq-card {
    display: flex;
    align-items: center;
    gap: 14px;
    padding: 20px;
    background: var(--card);
    border: 1px solid var(--border);
    border-radius: 12px;
  }
  .prereq-icon {
    font-size: 22px;
    flex-shrink: 0;
  }
  .prereq-text {
    font-size: 13px;
    color: var(--muted);
    line-height: 1.5;
  }
  .prereq-text strong {
    display: block;
    color: var(--text);
    font-size: 14px;
    margin-bottom: 2px;
  }

  /* ── ANIMATIONS ── */
  @keyframes fadeUp {
    from { opacity: 0; transform: translateY(20px); }
    to   { opacity: 1; transform: translateY(0); }
  }

  .animate-in {
    opacity: 0;
    transform: translateY(24px);
    transition: opacity 0.5s ease, transform 0.5s ease;
  }
  .animate-in.visible {
    opacity: 1;
    transform: translateY(0);
  }

  /* scrollbar */
  ::-webkit-scrollbar { width: 6px; height: 6px; }
  ::-webkit-scrollbar-track { background: var(--bg2); }
  ::-webkit-scrollbar-thumb { background: rgba(255,255,255,0.1); border-radius: 3px; }
  ::-webkit-scrollbar-thumb:hover { background: rgba(255,255,255,0.2); }
</style>
</head>
<body>

<div class="bg-blobs">
  <div class="blob blob1"></div>
  <div class="blob blob2"></div>
  <div class="blob blob3"></div>
</div>

<div class="container">

  <!-- HERO -->
  <header class="hero">
    <div class="hero-eyebrow">DSA From Scratch to Advance</div>
    <h1 class="hero-title">Master <span>Data Structures</span><br>&amp; Algorithms</h1>
    <p class="hero-sub">Beginner to advanced — crack coding interviews with confidence 🔥</p>

    <div class="hero-badges">
      <span class="badge badge-python">🐍 Python</span>
      <span class="badge badge-stars">⭐ Open Source</span>
      <span class="badge badge-forks">🔀 Fork &amp; Learn</span>
    </div>

    <div class="hero-stats">
      <div class="stat">
        <div class="stat-num">7+</div>
        <div class="stat-label">Phases</div>
      </div>
      <div class="stat">
        <div class="stat-num">60+</div>
        <div class="stat-label">Problems</div>
      </div>
      <div class="stat">
        <div class="stat-num">∞</div>
        <div class="stat-label">Potential</div>
      </div>
    </div>
  </header>

  <div class="divider"></div>

  <!-- FEATURES -->
  <section class="animate-in">
    <div class="section-tag">Why this repo</div>
    <h2 class="section-title">Everything you need to <em>win</em> interviews</h2>
    <div class="features">
      <div class="feature-card">
        <div class="feature-icon">🧹</div>
        <div class="feature-title">Crystal-Clear Code</div>
        <div class="feature-desc">Clean Python implementations you can read, understand, and remember.</div>
      </div>
      <div class="feature-card">
        <div class="feature-icon">🗺️</div>
        <div class="feature-title">Step-by-Step Roadmap</div>
        <div class="feature-desc">Structured phases from sorting basics to 2D binary search mastery.</div>
      </div>
      <div class="feature-card">
        <div class="feature-icon">🎯</div>
        <div class="feature-title">Real Problems</div>
        <div class="feature-desc">Curated challenges that interviewers at top companies actually ask.</div>
      </div>
      <div class="feature-card">
        <div class="feature-icon">📈</div>
        <div class="feature-title">Progressive Difficulty</div>
        <div class="feature-desc">Smooth progression from easy arrays all the way to hard challenges.</div>
      </div>
    </div>
  </section>

  <!-- TOC -->
  <section class="animate-in">
    <div class="toc">
      <div class="toc-title">// Quick Navigation</div>
      <div class="toc-grid">
        <a class="toc-item" href="#phase1"><span>📊</span> Sorting Algorithms</a>
        <a class="toc-item" href="#binarysearch"><span>🔍</span> Binary Search</a>
        <a class="toc-item" href="#phase2"><span>⭐</span> Easy Arrays</a>
        <a class="toc-item" href="#phase3"><span>🧠</span> Medium Arrays</a>
        <a class="toc-item" href="#phase4"><span>🔥</span> Hard Arrays</a>
        <a class="toc-item" href="#phase5"><span>🎯</span> BS on 1D Arrays</a>
        <a class="toc-item" href="#phase6"><span>🔲</span> BS in 2D Arrays</a>
        <a class="toc-item" href="#phase7"><span>🔤</span> Strings – Easy</a>
        <a class="toc-item" href="#prereqs"><span>🔧</span> Prerequisites</a>
      </div>
    </div>
  </section>

  <!-- PHASE 1 -->
  <section class="phase animate-in" id="phase1">
    <div class="phase-header">
      <div class="phase-number">PHASE 01</div>
      <h3 class="phase-title">Sorting Algorithms</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr>
            <th>Algorithm</th>
            <th>Best Case</th>
            <th>Worst Case</th>
            <th>Notes</th>
            <th>Code</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><strong>Bubble Sort</strong></td>
            <td><span class="complexity best">O(n)</span></td>
            <td><span class="complexity worst">O(n²)</span></td>
            <td style="color:var(--muted);font-size:12px">Swaps adjacent elements</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Sort-Algo/Bubble_Sort.py" target="_blank">Python</a></td>
          </tr>
          <tr>
            <td><strong>Insertion Sort</strong></td>
            <td><span class="complexity best">O(n)</span></td>
            <td><span class="complexity worst">O(n²)</span></td>
            <td style="color:var(--muted);font-size:12px">Great for nearly sorted data</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Sort-Algo/Insertion_Sort.py" target="_blank">Python</a></td>
          </tr>
          <tr>
            <td><strong>Selection Sort</strong></td>
            <td><span class="complexity worst">O(n²)</span></td>
            <td><span class="complexity worst">O(n²)</span></td>
            <td style="color:var(--muted);font-size:12px">Minimises swaps</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Sort-Algo/Selection.py" target="_blank">Python</a></td>
          </tr>
          <tr>
            <td><strong>Quick Sort</strong></td>
            <td><span class="complexity best">O(n log n)</span></td>
            <td><span class="complexity worst">O(n²)</span></td>
            <td style="color:var(--muted);font-size:12px">Divide & conquer, pivot-based</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Sort-Algo/Quick_Sort.py" target="_blank">Python</a></td>
          </tr>
          <tr>
            <td><strong>Merge Sort</strong></td>
            <td><span class="complexity best">O(n log n)</span></td>
            <td><span class="complexity best">O(n log n)</span></td>
            <td style="color:var(--muted);font-size:12px">Stable, consistent performance</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Sort-Algo/Merge_sort.py" target="_blank">Python</a></td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- BINARY SEARCH -->
  <section class="phase animate-in" id="binarysearch">
    <div class="phase-header">
      <div class="phase-number p2">BINARY SEARCH</div>
      <h3 class="phase-title">Foundations</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Topic</th><th>Notes</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr>
            <td><strong>Binary Search</strong></td>
            <td style="color:var(--muted);font-size:13px">O(log n) — Halve the search space each step</td>
            <td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach/BinarySreach.md" target="_blank">Read</a></td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 2 -->
  <section class="phase animate-in" id="phase2">
    <div class="phase-header">
      <div class="phase-number p3">PHASE 02</div>
      <h3 class="phase-title">Easy Array Challenges</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>⭐ Largest Element</td><td style="color:var(--muted);font-size:13px">Find maximum in an array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Maxout.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Second Largest</td><td style="color:var(--muted);font-size:13px">Without sorting</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/SecondMaxout.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Check if Sorted</td><td style="color:var(--muted);font-size:13px">Ascending order check</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Sortedornot.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Remove Duplicates</td><td style="color:var(--muted);font-size:13px">From sorted array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Remove.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Rotate by One</td><td style="color:var(--muted);font-size:13px">Left rotation</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/RotateLeft.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Move All Zeros</td><td style="color:var(--muted);font-size:13px">Push zeros to end</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Move0.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Linear Search</td><td style="color:var(--muted);font-size:13px">Find element in array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Linear.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Union of Arrays</td><td style="color:var(--muted);font-size:13px">Merge without duplicates</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Union.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Missing Element</td><td style="color:var(--muted);font-size:13px">In range 1–N</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Missing.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Max Consecutive 1s</td><td style="color:var(--muted);font-size:13px">Longest sequence of 1s</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/maxConsecBits.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Unique Element</td><td style="color:var(--muted);font-size:13px">Find non-repeating element</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Easy-Array/Uniquele.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Rotate Matrix 90°</td><td style="color:var(--muted);font-size:13px">Rotate 2D array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Rotateby90.java" target="_blank">Java</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 3 -->
  <section class="phase animate-in" id="phase3">
    <div class="phase-header">
      <div class="phase-number p4">PHASE 03</div>
      <h3 class="phase-title">Medium Array Challenges</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>⭐ Two Sum</td><td style="color:var(--muted);font-size:13px">Indices summing to target</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Twosum.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Sort 0s, 1s, 2s</td><td style="color:var(--muted);font-size:13px">Dutch National Flag</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Sort012.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Majority Element</td><td style="color:var(--muted);font-size:13px">Appears > n/2 times</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Majortyelement.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Max Subarray Sum</td><td style="color:var(--muted);font-size:13px">Kadane's Algorithm</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Maxsumarray.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Print Max Subarray</td><td style="color:var(--muted);font-size:13px">With actual values</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Printmaxsubarray.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Stock Buy &amp; Sell</td><td style="color:var(--muted);font-size:13px">Maximize profit</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/StockandBuy.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Rearrange Array</td><td style="color:var(--muted);font-size:13px">Alternate positive &amp; negative</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/RearrangeArray.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Next Permutation</td><td style="color:var(--muted);font-size:13px">Lexicographically next permutation</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/nextpermutation.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Leaders in Array</td><td style="color:var(--muted);font-size:13px">Find all leaders</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/LeaderArray.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Longest Increasing Subsequence</td><td style="color:var(--muted);font-size:13px">Strictly increasing subsequence</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/LongestSubsequnence.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Set Matrix Zero</td><td style="color:var(--muted);font-size:13px">Row &amp; column zeroing</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/SetMatrixZero.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Spiral Matrix</td><td style="color:var(--muted);font-size:13px">Traverse in spiral order</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/Sprialform.py" target="_blank">Python</a></td></tr>
          <tr><td>⭐ Count Subarrays (XOR)</td><td style="color:var(--muted);font-size:13px">Subarrays with given XOR</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Medium-Array/CountSubarray.py" target="_blank">Python</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 4 -->
  <section class="phase animate-in" id="phase4">
    <div class="phase-header">
      <div class="phase-number" style="background: linear-gradient(135deg,#f76a8a,#f7c96a);color:#0a0a0f;">PHASE 04</div>
      <h3 class="phase-title">Hard Array Challenges</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>🔥 Pascal's Triangle</td><td style="color:var(--muted);font-size:13px">Generate Pascal's triangle up to N rows</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/Pascaltriangle.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 3-Sum Problem</td><td style="color:var(--muted);font-size:13px">Find all triplets summing to zero</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/Threesum.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 4-Sum Problem</td><td style="color:var(--muted);font-size:13px">Find all unique quadruplets summing to target</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/Foursum.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 Count Inversions</td><td style="color:var(--muted);font-size:13px">Count pairs where left element &gt; right element</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/CountInversion.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 Merge Overlapping Intervals</td><td style="color:var(--muted);font-size:13px">Merge all overlapping intervals in an array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/MergeInterval.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 Missing &amp; Repeating Numbers</td><td style="color:var(--muted);font-size:13px">Find the missing and repeating element in array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/MissingRepeating.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 Largest Subarray with 0 Sum</td><td style="color:var(--muted);font-size:13px">Maximum length subarray having sum equal to zero</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/LargestSubarrayZeroSum.py" target="_blank">Python</a></td></tr>
          <tr><td>🔥 Longest Consecutive Sequence</td><td style="color:var(--muted);font-size:13px">Length of longest consecutive elements sequence</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Hard-Array/LongestConsecutive.py" target="_blank">Python</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 5 -->
  <section class="phase animate-in" id="phase5">
    <div class="phase-header">
      <div class="phase-number p5">PHASE 05</div>
      <h3 class="phase-title">Binary Search on 1D Arrays</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>⭐ Number of Occurrences</td><td style="color:var(--muted);font-size:13px">Count element in sorted array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/NumberofOccurence.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ First &amp; Last Occurrence</td><td style="color:var(--muted);font-size:13px">Find boundary indices</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/FristandLast.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Floor &amp; Ceil Value</td><td style="color:var(--muted);font-size:13px">Boundary values for target</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/FloorCiel.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Search Insert Position</td><td style="color:var(--muted);font-size:13px">Where to insert in sorted array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Sreachpostion.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Upper / Lower Bound</td><td style="color:var(--muted);font-size:13px">First strictly greater / ≥ x</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/UpperBound.java" target="_blank">Java</a></td></tr>
          <tr><td>🌀 Minimum in Rotated Array</td><td style="color:var(--muted);font-size:13px">Find min in rotated sorted array</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/RotatedArrayMinFinder.java" target="_blank">Java</a></td></tr>
          <tr><td>⛰️ Find Peak Element</td><td style="color:var(--muted);font-size:13px">Element greater than neighbors</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Peak.java" target="_blank">Java</a></td></tr>
          <tr><td>🧮 Square Root</td><td style="color:var(--muted);font-size:13px">Integer sqrt via binary search</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Squarert.java" target="_blank">Java</a></td></tr>
          <tr><td>🍌 Koko Eating Bananas</td><td style="color:var(--muted);font-size:13px">Minimum eating speed</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/KokoEatingBananas.java" target="_blank">Java</a></td></tr>
          <tr><td>🚢 Ship Packages in D Days</td><td style="color:var(--muted);font-size:13px">Least weight capacity</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Shippment.java" target="_blank">Java</a></td></tr>
          <tr><td>🐄 Aggressive Cows</td><td style="color:var(--muted);font-size:13px">Maximize minimum distance</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Aggresivecows.java" target="_blank">Java</a></td></tr>
          <tr><td>📚 Book Allocation</td><td style="color:var(--muted);font-size:13px">Minimize max pages assigned</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/bookallocation.java" target="_blank">Java</a></td></tr>
          <tr><td>✂️ Split Array Largest Sum</td><td style="color:var(--muted);font-size:13px">Minimize largest subarray sum</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/SplitArray.java" target="_blank">Java</a></td></tr>
          <tr><td>⚖️ Median of Two Sorted Arrays</td><td style="color:var(--muted);font-size:13px">O(log min(n,m)) approach</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-1D/Medainarray.java" target="_blank">Java</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 6 -->
  <section class="phase animate-in" id="phase6">
    <div class="phase-header">
      <div class="phase-number p6">PHASE 06</div>
      <h3 class="phase-title">Binary Search in 2D Arrays</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>⭐ Row with Max 1s</td><td style="color:var(--muted);font-size:13px">Row with most 1s in binary matrix</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-2D/Rowwith1s.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Search in 2D Matrix</td><td style="color:var(--muted);font-size:13px">Row and column sorted matrix</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-2D/Search2d.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Row &amp; Col Sorted Search</td><td style="color:var(--muted);font-size:13px">Both axes sorted efficiently</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-2D/Sreachin1and2.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Peak in 2D Matrix</td><td style="color:var(--muted);font-size:13px">Binary search for 2D peak</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-2D/Peakelement.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Matrix Median</td><td style="color:var(--muted);font-size:13px">BS on value range</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/Binary-Sreach-2D/Sreachin1and2.java" target="_blank">Java</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PHASE 7 -->
  <section class="phase animate-in" id="phase7">
    <div class="phase-header">
      <div class="phase-number p7">PHASE 07</div>
      <h3 class="phase-title">Strings – Easy</h3>
    </div>
    <div class="table-wrap">
      <table>
        <thead>
          <tr><th>Problem</th><th>Description</th><th>Code</th></tr>
        </thead>
        <tbody>
          <tr><td>⭐ Remove Outermost Parentheses</td><td style="color:var(--muted);font-size:13px">Strip outermost of every primitive</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/String-Easy/Outermost.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Reverse the String</td><td style="color:var(--muted);font-size:13px">Reverse words in a string</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/String-Easy/Reversewords.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Largest Number in String</td><td style="color:var(--muted);font-size:13px">Extract largest numeric value</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/String-Easy/Largestoddnumber.java" target="_blank">Java</a></td></tr>
          <tr><td>⭐ Longest Common Prefix</td><td style="color:var(--muted);font-size:13px">Across an array of strings</td><td><a class="link-btn" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/blob/main/String-Easy/Largestperfix.java" target="_blank">Java</a></td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- PREREQUISITES -->
  <section class="animate-in" id="prereqs">
    <div class="section-tag">Before you start</div>
    <h2 class="section-title"><em>Prerequisites</em></h2>
    <div class="prereqs">
      <div class="prereq-card">
        <div class="prereq-icon">☕</div>
        <div class="prereq-text">
          <strong>Java 8+</strong>
          Your brewing engine for coding challenges
        </div>
      </div>
      <div class="prereq-card">
        <div class="prereq-icon">💻</div>
        <div class="prereq-text">
          <strong>Java-friendly IDE</strong>
          IntelliJ, Eclipse, or VS Code
        </div>
      </div>
      <div class="prereq-card">
        <div class="prereq-icon">🧠</div>
        <div class="prereq-text">
          <strong>Programming Basics</strong>
          Logic, loops, and love for learning
        </div>
      </div>
    </div>
  </section>

  <!-- FOOTER -->
  <footer class="footer animate-in">
    <p class="footer-made">Made with ❤️ by <a href="https://github.com/vinayakmishra4" target="_blank">Vinayak Mishra</a></p>
    <div class="footer-actions">
      <a class="footer-btn primary" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE" target="_blank">⭐ Star on GitHub</a>
      <a class="footer-btn secondary" href="https://github.com/vinayakmishra4/DSA-FROM-SCRATCH-TO-ADVANCE/fork" target="_blank">🔀 Fork Repo</a>
    </div>
  </footer>

</div>

<script>
  // Intersection Observer for animate-in elements
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(e => {
      if (e.isIntersecting) {
        e.target.classList.add('visible');
        observer.unobserve(e.target);
      }
    });
  }, { threshold: 0.08 });

  document.querySelectorAll('.animate-in').forEach(el => observer.observe(el));

  // Smooth counter animation for hero stats
  function animateCount(el, target, suffix = '') {
    let start = 0;
    const dur = 1200;
    const step = (timestamp) => {
      if (!start) start = timestamp;
      const progress = Math.min((timestamp - start) / dur, 1);
      const ease = 1 - Math.pow(1 - progress, 3);
      el.textContent = Math.floor(ease * target) + suffix;
      if (progress < 1) requestAnimationFrame(step);
    };
    requestAnimationFrame(step);
  }

  const statsObs = new IntersectionObserver((entries) => {
    entries.forEach(e => {
      if (e.isIntersecting) {
        const nums = e.target.querySelectorAll('.stat-num');
        animateCount(nums[0], 7, '+');
        animateCount(nums[1], 60, '+');
        nums[2].textContent = '∞';
        statsObs.unobserve(e.target);
      }
    });
  }, { threshold: 0.5 });

  const heroStats = document.querySelector('.hero-stats');
  if (heroStats) statsObs.observe(heroStats);
</script>
</body>
</html>